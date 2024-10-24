package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.truckLoad.LpnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LpnRepository extends JpaRepository<LpnEntity,Long> {
    LpnEntity findByLpn(String lpn);
}
