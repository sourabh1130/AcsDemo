package com.Advatix.LoginApi.controller;

import com.Advatix.LoginApi.dto.OrderProductDto;
import com.Advatix.LoginApi.entity.Order.OmsOrderInfo;
import com.Advatix.LoginApi.service.OrderCreateService;
import com.Advatix.LoginApi.service.Box.OrderFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Advatix/orders")
public class OrderCreate {
    @Autowired
    private OrderCreateService orderCreateService;
    @PostMapping("/hurry")
    public String order(@RequestBody OmsOrderInfo omsOrderInfo){
        return orderCreateService.OrderPlaced(omsOrderInfo);
    }
    @Autowired
    private OrderFilterService orderFilterService;

    // Endpoint to get product ids by order number
    @GetMapping("/filter")
    public List<OrderProductDto> getProductsByOrderNumber(@RequestParam Long orderNumber) {
        return orderFilterService.getProductsByOrderNumber(orderNumber);
    }

}
