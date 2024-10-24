package com.Advatix.LoginApi.dto;

import com.Advatix.LoginApi.entity.truckLoad.LpnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LpnRepo extends JpaRepository<LpnEntity,Long> {
    LpnEntity findByLpn(String lpn);
}
