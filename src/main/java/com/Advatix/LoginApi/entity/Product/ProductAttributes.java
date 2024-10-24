package com.Advatix.LoginApi.entity.Product;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int attributeId;
    private String attributeName;
    private String status;
//    @ElementCollection
//    private Product product;

//    @JoinColumn(name = "product_id")
//    @JsonBackReference
//    private Product product;

}
