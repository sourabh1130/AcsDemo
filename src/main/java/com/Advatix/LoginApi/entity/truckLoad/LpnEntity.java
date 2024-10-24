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
public class LpnEntity {
    @Id
    private Long id;
    private String lpn;
    private String warehouse;
    private String shipFrom;
    private String shipTo;
    private Long status;
}
