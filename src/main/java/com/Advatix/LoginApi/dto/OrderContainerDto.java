package com.Advatix.LoginApi.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderContainerDto {
    private Long orderId;
    private String pickerName;
    private List<PickerUserDto> pickerUserDtoList;
}
