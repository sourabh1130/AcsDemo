package com.Advatix.LoginApi.entity.Warehouse.enums;

public enum MasterStatus {
    Initiated(0, "Initiated"),Created(1,"created"),BackOrder(18,"backorder"),Assigned(2,"assigned"),Packed(3,"packed"),ReadyToShip(6,"readyToShip")
    ;

    MasterStatus(int i, String initiated) {
    }
}
