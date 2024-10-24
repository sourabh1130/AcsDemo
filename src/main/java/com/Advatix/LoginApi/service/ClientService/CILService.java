package com.Advatix.LoginApi.service.ClientService;

import com.Advatix.LoginApi.dao.Orders.CILRepo;
import com.Advatix.LoginApi.entity.Order.OmsOrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CILService {
    @Autowired
    private CILRepo cilRepo;
    public String addOrderCIL(OmsOrderInfo omsOrderInfo){
        System.out.println(omsOrderInfo);
        cilRepo.save(omsOrderInfo);
        return "Done";
    }
}
