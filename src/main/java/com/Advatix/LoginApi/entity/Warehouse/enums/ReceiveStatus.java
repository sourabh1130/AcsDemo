package com.Advatix.LoginApi.entity.Warehouse.enums;


import lombok.Getter;

@Getter
public enum ReceiveStatus {
    RECEIVED(1, "Received"), STOW(2, "Stow"), AVIALABLE(3, "Available"),
    PICKED(5, "Picked"), COMPLETE(6, "Complete");

    private final Integer receiveId;

    private final String fieldName;

    ReceiveStatus(Integer receiveId, String fieldName) {
        this.receiveId = receiveId;
        this.fieldName = fieldName;
    }
}
