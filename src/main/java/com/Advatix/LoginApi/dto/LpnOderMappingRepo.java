package com.Advatix.LoginApi.dto;

import com.Advatix.LoginApi.entity.truckLoad.LpnOrderMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LpnOderMappingRepo extends JpaRepository<LpnOrderMappingEntity,Long> {
    boolean existsByOrder(String order);

    boolean existsById(String order);
}
