package com.Advatix.LoginApi.entity.Order;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "wh_order_info")
@Entity
@Data
public class FEPOrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_id")
    private Long orderId;
    private Long wId;
    private Long clientId;
    private int status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id_fk", referencedColumnName = "order_id")
    private List<FEPOrderItems> orderItemsList;
    private String shipFromName;
    private String shipFromAddress1;
    private String shipFromAddress2;
    private String shipFromCity;
    private String shipFromCountry;
    private String shipFromState;
    private Long shipFromPostalCode;
    private Boolean shipFromIsResidential;
    private String whName;
    private Long orderNumber;
}

