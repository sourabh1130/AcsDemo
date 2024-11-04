package com.Advatix.LoginApi.entity.TrackShipment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentJourney {
    @Id
    private Long id;
    private LocalDateTime statusTime;
    private String barCode;
    private String imagePath;
    private String statusDesc;
    private String webHook;
    private List<String> imagePaths;


    //
//    public void setImagePaths(List<String> imagePaths) {
//        this.imagePaths = imagePaths;
//    }

    public List<String> getImagePaths() {
        return imagePaths;
    }
}
