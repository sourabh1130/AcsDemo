package com.Advatix.LoginApi.entity.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    private Long cityId;
    private Long stateId;
    private Long countryId;

}
