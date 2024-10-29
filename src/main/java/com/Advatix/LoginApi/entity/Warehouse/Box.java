package com.Advatix.LoginApi.entity.Warehouse;

import com.Advatix.LoginApi.dto.BoxDimensionsDto;
import com.Advatix.LoginApi.entity.Warehouse.enums.BoxType;
import com.Advatix.LoginApi.entity.Warehouse.enums.MasterStatus;
import com.Advatix.LoginApi.entity.Warehouse.enums.PickerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long wId;

    @Enumerated(EnumType.STRING)
    private BoxType type;
    private MasterStatus status;
    private Long boxId;
    private Long orderNumber;
    private Double weight;
    private Double length;
    private Double width;
    private Double height;

}
