package com.Advatix.LoginApi.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ASNNoticeRequestDto {
    private String poNumber;
    private String lotNumber;
    private Long totalQuantity;
    private LocalDate createdOn;
    private Long createdBy;
    private Long warehouseId;
    private List<ASNUnitRequest> asnUnitList;
}
