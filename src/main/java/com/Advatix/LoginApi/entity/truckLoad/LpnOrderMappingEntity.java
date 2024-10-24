package com.Advatix.LoginApi.entity.truckLoad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LpnOrderMappingEntity {
    @Id
    private String id;
    private String lpn;
    private String order;
}
