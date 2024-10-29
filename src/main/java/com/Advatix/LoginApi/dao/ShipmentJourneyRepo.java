package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.TrackShipment.ShipmentJourney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentJourneyRepo extends JpaRepository<ShipmentJourney,Long> {

}
