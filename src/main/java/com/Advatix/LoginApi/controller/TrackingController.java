package com.Advatix.LoginApi.controller;

import com.Advatix.LoginApi.dto.TrackingRequestDto;
import com.Advatix.LoginApi.dto.TrackingResponseDto;
import com.Advatix.LoginApi.service.ship.TrackShipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    @Autowired
    private TrackShipment trackShipmentService;

    @PostMapping("/track")
    public ResponseEntity<TrackingResponseDto> trackShipment(@RequestBody TrackingRequestDto requestDto) {
        TrackingResponseDto responseDto = trackShipmentService.trackOrder(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}