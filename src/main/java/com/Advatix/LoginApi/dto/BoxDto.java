package com.Advatix.LoginApi.dto;

import com.Advatix.LoginApi.entity.Warehouse.enums.BoxType;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class BoxDto {
    private Integer quantity;
    private Long id;
    private Long boxId;
    private Long warehouseId;
    private BoxType boxType;
    private Long orderNumber;
    private Double weight;
    private BoxDimensionsDto boxDimensions;

}






//    we will give the number of product to pick and you have to put the condition on that and allot a box to particular product. After alloting a box, make box status active to inactive in a database and return the list of same boxtype id of boxes