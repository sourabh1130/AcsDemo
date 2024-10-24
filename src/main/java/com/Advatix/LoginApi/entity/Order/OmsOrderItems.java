package com.Advatix.LoginApi.entity.Order;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "oms_order_items")
@Data
public class OmsOrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private Long productId;

    private Long productQty;
    @Column(name = "order_id_fk")
    private Long orderIdFk;  // Foreign key to CILOrderInfo
}
