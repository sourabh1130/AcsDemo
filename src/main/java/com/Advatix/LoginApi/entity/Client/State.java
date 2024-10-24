package com.Advatix.LoginApi.entity.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class State {

    @Id
    private Long stateId;
    private String stateName;
    private Long countryId;
}
