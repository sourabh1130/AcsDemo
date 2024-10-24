package com.Advatix.LoginApi.service.ship;

import com.Advatix.LoginApi.dao.Orders.CILOrderInfoRepo;
import com.Advatix.LoginApi.dao.Orders.FEPRepo;
import com.Advatix.LoginApi.dao.WarehouseRepo;
import com.Advatix.LoginApi.dao.WhBoxLabelRepo;
import com.Advatix.LoginApi.dto.OrderDetailsDto;
import com.Advatix.LoginApi.entity.Order.FEPOrderInfo;
import com.Advatix.LoginApi.entity.Order.OmsOrderInfo;
import com.Advatix.LoginApi.entity.Warehouse.WhBoxLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FetchBox {
    @Autowired
    private WhBoxLabelRepo whBoxLabelRepo;

    @Autowired
    private CILOrderInfoRepo cilOrderInfoRepo;

    @Autowired
    private WarehouseRepo warehouseRepo;

    @Autowired
    private FEPRepo fepRepo;

    public OrderDetailsDto getOrderDetailsByBoxLabel(Long id){
        Optional<WhBoxLabel> optionalBoxLabel=whBoxLabelRepo.findById(id);
        if (optionalBoxLabel.isEmpty()){
            throw new RuntimeException("Box Label not found");
        }
        WhBoxLabel boxLabel=optionalBoxLabel.get();
        Long orderNumber=boxLabel.getOrderNumber();

        List<OmsOrderInfo> optionalOrder = cilOrderInfoRepo.findByOrderNumber(orderNumber);
        if(optionalOrder.isEmpty()){
            throw new RuntimeException("Order not found");
        }
        OmsOrderInfo order=optionalOrder.get(0);

        OrderDetailsDto orderDetailsDto=new OrderDetailsDto();
        orderDetailsDto.setOrderId(order.getOrderId());
        orderDetailsDto.setOrderNumber(order.getOrderNumber());
//        orderDetailsDto.setShippedFrom(order.getShippedFrom());
//        orderDetailsDto.setShippedTo(order.getShippedTo());
        orderDetailsDto.setCarrier(order.getCarrier());
        orderDetailsDto.setShipToName(order.getShipToName());
        orderDetailsDto.setShipToAddress1(order.getShipToAddress1());
        orderDetailsDto.setShipToAddress2(order.getShipToAddress2());
        orderDetailsDto.setShipToCity(order.getShipToCity());
        orderDetailsDto.setShipToState(order.getShipToState());
        orderDetailsDto.setShipToCountry(order.getShipToCountry());
        orderDetailsDto.setShipToPostalCode(order.getShipToPostalCode());
        orderDetailsDto.setShipToIsResidential(order.getShipToIsResidential());
        orderDetailsDto.setServiceType(order.getServiceType());
        orderDetailsDto.setWId(order.getWId());


        List<FEPOrderInfo> listOrder = fepRepo.findByOrderNumber(orderNumber);
        if(listOrder.isEmpty()){
            throw new RuntimeException("Order not found");
        }
        FEPOrderInfo order1=listOrder.get(0);

        orderDetailsDto.setShipFromName(order1.getShipFromName());
        orderDetailsDto.setShipFromAddress1(order1.getShipFromAddress1());
        orderDetailsDto.setShipFromAddress2(order1.getShipFromAddress2());
        orderDetailsDto.setShipFromCity(order1.getShipFromCity());
        orderDetailsDto.setShipFromState(order1.getShipFromState());
        orderDetailsDto.setShipFromCountry(order1.getShipFromCountry());
        orderDetailsDto.setShipFromIsResidential(order1.getShipFromIsResidential());
        orderDetailsDto.setShipFromPostalCode(order1.getShipFromPostalCode());


        return orderDetailsDto;
    }
}
