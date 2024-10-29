package com.Advatix.LoginApi.entity.Product;

import com.Advatix.LoginApi.entity.Warehouse.enums.InventoryStage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pId;
    private Long clientId;
    private InventoryStage pStatus;
    @Column(unique=true)
    private String sku;
    @Column(unique=true)
    private String upc;
    private String pName;
    private String pDescription;
    private String category;
    private Long createdBy;
    private LocalDateTime createdOn;
    private Long productId;
    private Long userId;
}
