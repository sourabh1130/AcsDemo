package com.Advatix.LoginApi.controller;

import com.Advatix.LoginApi.dto.LpnRequestDto;
import com.Advatix.LoginApi.service.TruckLoadSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/truckLoad")
public class TruckLoadController {
    @Autowired
    private TruckLoadSerivce truckLoadSerivce;

    @PostMapping("/assignOrder")
    public ResponseEntity<String> assignOrderToLpn(@RequestBody LpnRequestDto lpnRequestDto){
        String response=truckLoadSerivce.assignOrderToLpn(lpnRequestDto);
        if(response.equals("Order successfuly assigned to Lpn  :"+lpnRequestDto.getLpn())){
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.badRequest().body(response);
        }
    }
}
