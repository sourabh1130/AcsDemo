package com.Advatix.LoginApi.dao.Orders;

import com.Advatix.LoginApi.entity.Order.OmsOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CILRepo extends JpaRepository<OmsOrderInfo,Long> {
}
