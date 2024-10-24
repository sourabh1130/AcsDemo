package com.Advatix.LoginApi.entity.Order;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wh_order_items")
@Data

public class FEPOrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private Long productId;

    private Long productQty;
    private Long orderId;
}
