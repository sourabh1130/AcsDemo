package com.Advatix.LoginApi.entity.Warehouse;

import com.Advatix.LoginApi.entity.Warehouse.enums.InventoryStage;
import com.Advatix.LoginApi.entity.Warehouse.enums.ReceiveStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseRecivedItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private Long warehouseId;
    private Long customerId;
    private String locationBarcode;
    private Long clientId;
    private ReceiveStatus receiveStatus;
    private Long employeeId;
    private InventoryStage inventoryStage;
    private Long quantity;
    private String lotNumber;
    private Long userId;
    private LocalDate createdOn;
}
