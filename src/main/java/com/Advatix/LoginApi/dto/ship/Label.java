package com.Advatix.LoginApi.dto.ship;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
public class Label {

    private Integer id;

    @JsonProperty("label_url")
    private String labelUrl;
    private Double cost;
    @JsonProperty("final_mile_carrier")
    private String finalMileCarrier;
    @JsonProperty("tracking_url")
    private String trackingUrl;
    @JsonProperty("tracking_number")
    private String trackingNumber;
    @JsonProperty("label_format")
    private String labelFormat;

    public Integer getID(){return id;}


}
