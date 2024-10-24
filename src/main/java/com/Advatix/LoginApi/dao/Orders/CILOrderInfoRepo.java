package com.Advatix.LoginApi.dao.Orders;

import com.Advatix.LoginApi.entity.Order.OmsOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CILOrderInfoRepo extends JpaRepository<OmsOrderInfo,Long> {


    List<OmsOrderInfo> findByOrderNumber(Long orderNumber);


    Optional<OmsOrderInfo> findByOrderId(Long orderId);
}
