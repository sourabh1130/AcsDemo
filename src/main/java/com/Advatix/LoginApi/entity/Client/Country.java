package com.Advatix.LoginApi.entity.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Country {
    @Id
    private Long countryId;
    private String countryName;
    private String shortName;
}
