package com.Advatix.LoginApi.controller;

import com.Advatix.LoginApi.dto.BoxDto;
import com.Advatix.LoginApi.entity.Warehouse.WhBoxLabel;
import com.Advatix.LoginApi.service.Box.BoxLabelService;
import com.Advatix.LoginApi.service.Box.OrderFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boxes")
public class BoxController {

    @Autowired
    private BoxLabelService boxLabelService;

    @Autowired
    OrderFilterService orderFilterService;

    @PostMapping("/print")
//    public ResponseEntity<?> printBoxLabel(@RequestBody BoxDto boxDto){
//        List<Long> getIds= boxLabelService.printBoxLabel(boxDto);
//        return new ResponseEntity<>(getIds, HttpStatus.OK);
//    }
    public ResponseEntity<?> printBoxLabels(@RequestBody BoxDto boxDto) {
        // Validate input quantity
        if (boxDto.getQuantity() == null || boxDto.getQuantity() <= 0) {
            return new ResponseEntity<>("Quantity must be greater than zero", HttpStatus.BAD_REQUEST);
        }

        // Call the service to print the box labels
        List<Long> boxIds = boxLabelService.printBoxLabel(boxDto);

        // Return an appropriate response
        if (boxIds.isEmpty()) {
            return new ResponseEntity<>("No box available or unable to allocate boxes", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(boxIds, HttpStatus.OK);
        }
    }



    // Endpoint to get active boxes and print their labels
    @GetMapping("/active")
    public List<WhBoxLabel> getActiveBoxes() {
        List<WhBoxLabel> activeBoxes = boxLabelService.getActiveBoxes();
        boxLabelService.printBoxLabels(activeBoxes); // This calls the printBoxDetails method internally
        return activeBoxes;
    }
//    @GetMapping("/print")
//    public List<String> printAndReturnBoxLabels() {
//        List<WhBoxLabel> activeBoxes = boxLabelService.getActiveBoxes();
//        return boxLabelService.getPrintedBoxLabels(activeBoxes); // Print and return formatted labels
//    }

    @GetMapping("/getOrders")
    public ResponseEntity<?> orderId(@RequestParam Long orderId){
        List<Long> getIds = orderFilterService.getProductIdsByOrderId(orderId);
        return new ResponseEntity<>(getIds,HttpStatus.OK);
    }

}




