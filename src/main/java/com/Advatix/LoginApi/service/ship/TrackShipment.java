package com.Advatix.LoginApi.service.ship;

import com.Advatix.LoginApi.dao.ShipmentJourneyRepo;
import com.Advatix.LoginApi.dao.ThirdPartyStatusRepo;
import com.Advatix.LoginApi.dto.TrackingRequestDto;
import com.Advatix.LoginApi.dto.TrackingResponseDto;
import com.Advatix.LoginApi.entity.TrackShipment.ShipmentJourney;
import com.Advatix.LoginApi.entity.TrackShipment.ThirdPartyStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TrackShipment {

    private static final String API_URL = "https://trk.speedx.io/tracking-api/event/external/v2?version=2%27";
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ThirdPartyStatusRepo thirdPartyStatusRepo;

    @Autowired
    private ShipmentJourneyRepo shipmentJourneyRepo;

    public TrackingResponseDto trackOrder(TrackingRequestDto requestDto) {
        TrackingResponseDto responseDto = new TrackingResponseDto();

        try {
            // Set up headers for the request
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("api-key", "97df1c-1bcebb-64f88d-76ad0a-1b626a");

            HttpEntity<TrackingRequestDto> requestEntity = new HttpEntity<>(requestDto, headers);
            ResponseEntity<String> response = restTemplate.exchange(new URI(API_URL), HttpMethod.POST, requestEntity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response.getBody());


            if (root.path("code").asInt() != 200 || !root.path("success").asBoolean()) {
                throw new RuntimeException("Third-party API returned an error: " + root.path("message").asText());
            }

            JsonNode trackingInfo = root.path("payload").path("trackingNumbers").get(0);
            String trackingNumber = trackingInfo.path("trackingNumber").asText();
            List<TrackingResponseDto.Event> eventsList = new ArrayList<>();

            // Loop through each event in trackingInfo.path("events")
            for (JsonNode eventNode : trackingInfo.path("events")) {
                String eventCode = eventNode.path("eventCode").asText();
                OffsetDateTime eventTime = OffsetDateTime.parse(eventNode.path("ts").asText());
                String zuluEventTime = eventTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                String customerRefId = eventNode.path("customerRefId").asText();
                String localTs = eventNode.path("localTs").asText();
                String timeZone = eventNode.path("timeZone").asText();
                String description = eventNode.path("description").asText();
                String location = eventNode.path("location").asText();
                String category = eventNode.path("category").asText();

                // Add each event to the list
                eventsList.add(new TrackingResponseDto.Event(
                        eventCode, zuluEventTime, customerRefId, localTs, timeZone,
                        description, location, category, null, description, null
                ));
            }

            // Get image URL from pods
            String imageUrl = trackingInfo.path("pods").get(0).asText();

            // Save to ThirdPartyStatus
            ThirdPartyStatus thirdPartyStatus = new ThirdPartyStatus();
            thirdPartyStatus.setId(Long.valueOf(requestDto.getTrackingNumbers().hashCode()));
            thirdPartyStatus.setTStatus(trackingInfo.path("events").get(0).path("category").asText());
            thirdPartyStatus.setStatusTime(OffsetDateTime.parse(trackingInfo.path("events").get(0).path("ts").asText()).toLocalDateTime());
            thirdPartyStatus.setBarCode(trackingNumber);
            thirdPartyStatus.setImagePath(downloadImage(imageUrl, trackingNumber));
            thirdPartyStatus.setStatusDesc(trackingInfo.path("events").get(0).path("description").asText());
            thirdPartyStatusRepo.save(thirdPartyStatus);

            // Save to ShipmentJourney
            ShipmentJourney shipmentJourney = new ShipmentJourney();
            shipmentJourney.setId(Long.valueOf(requestDto.getTrackingNumbers().hashCode()));
            shipmentJourney.setStatusTime(OffsetDateTime.parse(trackingInfo.path("events").get(0).path("ts").asText()).toLocalDateTime());
            shipmentJourney.setBarCode(trackingNumber);
            shipmentJourney.setImagePath(imageUrl);
            shipmentJourney.setStatusDesc(trackingInfo.path("events").get(0).path("description").asText());
            shipmentJourney.setWebHook(API_URL);
            shipmentJourneyRepo.save(shipmentJourney);

            // Populate response DTO
            responseDto.setCode(200);
            responseDto.setMessage("SUCCESS");
            responseDto.setSuccess(true);
            responseDto.setPayload(new TrackingResponseDto.Payload(Collections.singletonList(
                    new TrackingResponseDto.TrackingNumber(trackingNumber, "US", null, eventsList, Collections.singletonList(imageUrl), null, null)
            )));

        } catch (Exception e) {
            e.printStackTrace();
            responseDto.setCode(500);
            responseDto.setMessage(e.getMessage());
            responseDto.setSuccess(false);
        }

        return responseDto;
    }

    private String downloadImage(String imageUrl, String trackingNumber) {
        try {
            // Define the path where you want to save the image
            Path imagePath = Paths.get("C:\\Images\\" + trackingNumber + ".jpg");

            // Create a GET request to download the image
            ResponseEntity<byte[]> imageResponse = restTemplate.getForEntity(imageUrl, byte[].class);
            Files.write(imagePath, imageResponse.getBody()); // Save the image to the file system
            return imagePath.toString(); // Return the path to the saved image
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle any errors during the image download
        }
    }
}
