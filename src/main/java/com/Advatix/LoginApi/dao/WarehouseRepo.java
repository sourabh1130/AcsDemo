package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.Warehouse.WareHouse;
import com.Advatix.LoginApi.entity.Warehouse.WarehouseRecivedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseRepo extends JpaRepository<WarehouseRecivedItems,Integer> {

    Optional<WarehouseRecivedItems> findByProductId(Long productId);

    Optional<WareHouse> findById(Long id);
}
