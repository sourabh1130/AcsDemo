package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.Shipment.ASNNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ASSNoticeRepo extends JpaRepository<ASNNotice,Long> {
}
