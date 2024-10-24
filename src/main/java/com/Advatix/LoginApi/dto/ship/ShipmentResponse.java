package com.Advatix.LoginApi.dto.ship;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ShipmentResponse {
    @JsonProperty("shipment_id")
    private Integer shipmentId;
    @JsonProperty("rate_id")
    private Integer rateId;
    @JsonProperty("shipment_tracking_number")
    private String trackingNumber;
    private String confirmation;
    private List<Label> labels;



}
