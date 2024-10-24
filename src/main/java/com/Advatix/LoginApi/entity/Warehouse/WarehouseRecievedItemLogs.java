package com.Advatix.LoginApi.entity.Warehouse;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseRecievedItemLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wId;
    private Long productID;
    private Long clientId;
    private Long warehouseId;
    private String locationBarcode;
    private Boolean recievedStatus;
    private String inventoryStage;
    private Integer quantity;
    private String lotNumber;
    private Long userId;
    private LocalDateTime createOn;
    private String operationType;
}
