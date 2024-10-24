package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.Warehouse.WhBoxLabel;
import com.Advatix.LoginApi.entity.Warehouse.enums.BoxType;
import com.Advatix.LoginApi.entity.Warehouse.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WhBoxLabelRepo extends JpaRepository<WhBoxLabel,Long> {
    //List<WhBoxLabel> findByBoxStatus(String status);


    List<WhBoxLabel> findByBoxStatus(OrderStatus orderStatus);

    Optional<WhBoxLabel> findById(Long id);


    List<WhBoxLabel> findByWarehouseIdAndBoxTypeAndBoxStatus(Long warehouseId, BoxType boxType, OrderStatus orderStatus);


}
