package com.Advatix.LoginApi.service;

import com.Advatix.LoginApi.dao.LpnOrderMappingRepo;
import com.Advatix.LoginApi.dao.LpnRepository;
import com.Advatix.LoginApi.dto.LpnRequestDto;
import com.Advatix.LoginApi.entity.truckLoad.LpnEntity;
import com.Advatix.LoginApi.entity.truckLoad.LpnOrderMappingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckLoadSerivce {
    @Autowired
    private LpnOrderMappingRepo lpnOrderMappingRepo;
    @Autowired
    private LpnRepository lpnRepository;

    public String assignOrderToLpn(LpnRequestDto lpnRequestDto){
        if(lpnRequestDto.getOrderStatus()!=1){
            return "Order not ready to ship";

        }
        if(lpnOrderMappingRepo.existsByOrderName(lpnRequestDto.getOrderName())){
            return "order is already assigned to another Lpn";
        }
        LpnEntity lpnEntity= lpnRepository.findByLpn(lpnRequestDto.getLpn());
        if(lpnEntity==null){
            return "order not found";
        } else if (lpnRequestDto.getOrderStatus()==6) {
            LpnOrderMappingEntity mapping=new LpnOrderMappingEntity();
            mapping.setLpn(lpnRequestDto.getLpn());
            mapping.setOrderName(lpnRequestDto.getOrderName());

            lpnOrderMappingRepo.save(mapping);

            return "order successfully assigned to Lpn  :";
        }
        return lpnRequestDto.getLpn();

    }

}
