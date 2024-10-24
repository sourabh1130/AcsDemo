package com.Advatix.LoginApi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LpnRequestDto {
    private String lpn;
    private String order;
    private Long orderStatus;
}
