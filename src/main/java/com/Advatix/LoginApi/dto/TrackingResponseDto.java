package com.Advatix.LoginApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackingResponseDto {
    private int code;
    private String message;
    private Payload payload;
    private boolean success;
//    private String pdfFilePath;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Payload {
        private List<TrackingNumber> trackingNumbers;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TrackingNumber {
        private String trackingNumber;
        private String country;
        private String edd;
        private List<Event> events;
        private List<String> pods;
        private String errorMsg;
        private String errorCode;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Event {
        private String eventCode;
        private String ts;
        private String customerRefId;
        private String localTs;
        private String timeZone;
        private String description;
        private String location;
        private String category;
    //    private String imagePath;
//

        @JsonIgnore
        private String occurredAt;

        @JsonIgnore
        private String eventDescription;

        @JsonIgnore
        private String eventSupplementalInfo;
    }
}
