package com.Advatix.LoginApi.entity.Client;

import jakarta.persistence.*;

import lombok.Data;

import jakarta.persistence.Id;

@Entity
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    private String clientName;
    private Long clientPhno;
    private String clientMail;
    private String address1;
    private String city;
    private String state;
    private String country;
    private Long cityId;
//
}
