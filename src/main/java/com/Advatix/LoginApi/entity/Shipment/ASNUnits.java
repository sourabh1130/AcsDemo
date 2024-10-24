package com.Advatix.LoginApi.entity.Shipment;

import com.Advatix.LoginApi.entity.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "asn_notice_units")
@AllArgsConstructor
public class ASNUnits {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long unitId;

    private Long quantity;

    private Long receivedQty;

    private String location;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ASNUnits(Long quantity, Long receivedQty, String location, Product product) {
        this.quantity = quantity;
        this.receivedQty = receivedQty;
        this.location = location;
        this.product = product;
    }


}
