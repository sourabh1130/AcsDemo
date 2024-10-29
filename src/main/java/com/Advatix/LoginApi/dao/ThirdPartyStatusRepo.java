package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.TrackShipment.ThirdPartyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyStatusRepo extends JpaRepository<ThirdPartyStatus,Long> {
}
