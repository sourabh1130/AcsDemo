package com.Advatix.LoginApi.dao.Orders;

import com.Advatix.LoginApi.entity.Order.FEPOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FEPRepo extends JpaRepository<FEPOrderInfo,Long> {
    List<FEPOrderInfo> findByOrderNumber(Long orderNumber);
}
