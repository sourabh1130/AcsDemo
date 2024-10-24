package com.Advatix.LoginApi.controller;

import com.Advatix.LoginApi.dto.BoxDto;
import com.Advatix.LoginApi.dto.OrderDetailsDto;
import com.Advatix.LoginApi.entity.Warehouse.Box;
import com.Advatix.LoginApi.service.ship.FetchBox;
import com.Advatix.LoginApi.service.ship.ShipmentLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fetch-box")
public class BoxToShipController {

    @Autowired
    private FetchBox fetchBox;

    @Autowired
    private ShipmentLabelService shipmentLabelService;


    @GetMapping("/order")
    public ResponseEntity<OrderDetailsDto> getOrderDetails(@RequestParam Long id){
        OrderDetailsDto orderDetailsDto= shipmentLabelService.getOrderDetailsByBoxLabel(id);
        return new ResponseEntity<>(orderDetailsDto, HttpStatus.OK);
    }

    @PostMapping("/{id}/details")
    public ResponseEntity<Box> updateBoxDetails(@PathVariable Long id, @RequestBody BoxDto boxDto) {
        Box updatedBox = shipmentLabelService.setOrderDetailsByBoxID(id, boxDto);
        return ResponseEntity.ok(updatedBox);
    }

    @PostMapping("/generate-label/{id}")
    public ResponseEntity<?> generateShipmentLabel(@PathVariable Long id) {
        try {
            return shipmentLabelService.resttemp(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error occurred while generating label", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
