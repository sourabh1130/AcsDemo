package com.Advatix.LoginApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    private Long boxId;
    private Long orderId;
    private String shipToName;
    private String shipToAddress1;
    private String shipToAddress2;
    private String shipToCity;
    private String shipToCountry;
    private String shipToState;
//  private String shippedFrom;
    private Boolean shipToIsResidential;
    private Long shipToPostalCode;
    private Long wId;
    private String shipFromName;
    private String shipFromAddress1;
    private String shipFromAddress2;
    private String shipFromCity;
    private String shipFromCountry;
    private String shipFromState;
    private Long shipFromPostalCode;
    private Boolean shipFromIsResidential;
    private String whName;
    private Long orderNumber;
    private String carrier;
    private String serviceType;

}
