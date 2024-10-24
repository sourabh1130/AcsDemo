package com.Advatix.LoginApi.controller;
import com.Advatix.LoginApi.dto.ASNNoticeRequestDto;
import com.Advatix.LoginApi.entity.Shipment.ASNNotice;
import com.Advatix.LoginApi.service.ASNService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asn")
public class ASNController {

    @Autowired
    ASNService asnService;


    @PostMapping("/Advatix/create-Asn")
    public ASNNotice addASNNotice(@RequestBody ASNNoticeRequestDto asnNotice){

        return asnService.addASN(asnNotice);
    }
}
