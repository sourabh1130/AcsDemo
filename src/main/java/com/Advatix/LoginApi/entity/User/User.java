package com.Advatix.LoginApi.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;//Integer
    private String uName;
    private Long roleId;
    private String mail;
    private Integer pNo;
    private Boolean status;//integer
    private String password;
    private Long clientId;//
    private Long cityID;//



    public List<String> findById(Long uid) {
        List<String> items = new ArrayList<>();
        return items;
    }

    public void setClientId(Long clientId) {
    }

    public void findAllUsers(Long uid) {

    }

    public String getUserName() {
        return uName;
    }
}
