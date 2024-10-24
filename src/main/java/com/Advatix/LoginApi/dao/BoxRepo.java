package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.Warehouse.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoxRepo extends JpaRepository<Box,Long> {
    List<Box> findByStatus(String status);

    List<Box> findByOrderNumber(Long orderNumber);


}
