package com.Advatix.LoginApi.dto;

import lombok.Data;

@Data
public class OrderProductDto {
    private Long orderId;
    private Long productId;

    public OrderProductDto(Long orderId, Long productId){
        this.orderId=orderId;
        this.productId=productId;
    }
}
