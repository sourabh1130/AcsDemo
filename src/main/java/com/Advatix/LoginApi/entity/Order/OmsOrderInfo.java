package com.Advatix.LoginApi.entity.Order;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "oms_order_info")
@Entity
@Data
public class OmsOrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long boxId;
    @Column(name = "order_id")
    private Long orderId;
    private Long clientId;
    private String reason;
    private int status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id_fk", referencedColumnName = "order_id")
    private List<OmsOrderItems> orderItemsList;
    private Long orderNumber;
    private String shipToName;
    private String shipToAddress1;
    private String shipToAddress2;
    private String shipToCity;
    private String shipToCountry;
    private String shipToState;
//    private String shippedFrom;
    private Boolean shipToIsResidential;
    private Long shipToPostalCode;
    private String shippedTo;
    private String carrier;
    private String serviceType;
    private Long wId;
}