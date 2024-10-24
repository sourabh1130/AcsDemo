package com.Advatix.LoginApi.entity.Warehouse;

import com.Advatix.LoginApi.entity.Warehouse.enums.BoxType;
import com.Advatix.LoginApi.entity.Warehouse.enums.PickerStatus;
import com.Advatix.LoginApi.entity.Warehouse.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WhBoxLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long warehouseId;
    @Enumerated(value = EnumType.STRING)
    private BoxType boxType;
    @Enumerated(value = EnumType.STRING)
    private PickerStatus status;
    @Enumerated(value =EnumType.STRING)
    private OrderStatus boxStatus;
    private Long orderNumber;

//    public String getWId() {
//        ;
//    }
}
