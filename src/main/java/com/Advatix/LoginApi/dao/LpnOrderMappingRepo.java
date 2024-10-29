package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.truckLoad.LpnOrderMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LpnOrderMappingRepo extends JpaRepository<LpnOrderMappingEntity,Integer> {
    boolean existsByOrderName(String orderName);
    boolean existsById(Long orderId);


}
