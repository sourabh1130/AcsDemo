package com.Advatix.LoginApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.dialect.LobMergeStrategy;

@Data
@AllArgsConstructor
public class ASNUnitRequest {
    private Long quantity;
    private Long receivedQuantity;
    private String location;
    private Long productId;
}


