package com.Advatix.LoginApi.entity.TrackShipment;

import com.Advatix.LoginApi.entity.Warehouse.enums.MasterStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThirdPartyStatus {
    @Id
    private Long id;
    private String tStatus;
    private LocalDateTime statusTime;
    private String barCode;
    private String imagePath;
    private String statusDesc;
}
