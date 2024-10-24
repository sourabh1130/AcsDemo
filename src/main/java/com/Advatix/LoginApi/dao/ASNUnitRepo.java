package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.Shipment.ASNUnits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ASNUnitRepo extends JpaRepository<ASNUnits,Long> {
}
