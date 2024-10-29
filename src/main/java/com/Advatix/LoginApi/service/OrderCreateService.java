package com.Advatix.LoginApi.service;

import com.Advatix.LoginApi.dao.Orders.FEPRepo;
import com.Advatix.LoginApi.dao.WarehouseRepo;
import com.Advatix.LoginApi.entity.Order.OmsOrderInfo;
import com.Advatix.LoginApi.entity.Order.OmsOrderItems;
import com.Advatix.LoginApi.entity.Order.FEPOrderInfo;
import com.Advatix.LoginApi.entity.Order.FEPOrderItems;
import com.Advatix.LoginApi.entity.Warehouse.WarehouseRecivedItems;
import com.Advatix.LoginApi.entity.Warehouse.enums.MasterStatus;
import com.Advatix.LoginApi.service.ClientService.CILService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderCreateService {
    @Autowired
    private FEPRepo fepRepo;
    @Autowired
    private CILService cilService;
    @Autowired
    private WarehouseRepo warehouseRepo;

    public String OrderPlaced(OmsOrderInfo omsOrderInfo){
        try{
            cilService.addOrderCIL(omsOrderInfo);
            List<OmsOrderItems> orderItemsList= omsOrderInfo.getOrderItemsList();
            boolean check;
            for(OmsOrderItems e:orderItemsList){
                Optional<WarehouseRecivedItems> wareHouseItems = warehouseRepo.findByProductId(e.getProductId());
                if(wareHouseItems.isPresent()){
                    if(wareHouseItems.get().getQuantity()>=e.getProductQty()){
                        wareHouseItems.get().setQuantity(wareHouseItems.get().getQuantity()-e.getProductQty());
                        omsOrderInfo.setStatus(MasterStatus.Created);
                        cilService.addOrderCIL(omsOrderInfo);
                        warehouseRepo.save(wareHouseItems.get());   //save
                        FEPOrderInfo fepOrderInfo=new FEPOrderInfo();
                        fepOrderInfo.setClientId(omsOrderInfo.getClientId());
                        fepOrderInfo.setStatus(1);
                        fepOrderInfo.setOrderId(omsOrderInfo.getOrderId());
                        List<FEPOrderItems> feplist=new ArrayList<>();
                           FEPOrderItems fepOrderItems=new FEPOrderItems();
                           fepOrderItems.setProductId(e.getProductId());
                           fepOrderItems.setProductQty(e.getProductQty());
                           feplist.add(fepOrderItems);
                           fepOrderInfo.setOrderItemsList(feplist);
                           fepRepo.save(fepOrderInfo);

                    }else if(wareHouseItems.get().getQuantity()<e.getProductQty()){
                        long qn=wareHouseItems.get().getQuantity()-e.getProductQty();
                        if(qn<0){
                            wareHouseItems.get().setQuantity(0L);
                            omsOrderInfo.setStatus(MasterStatus.BackOrder);
                            e.setProductQty(qn*-1);
                            omsOrderInfo.setReason("backorder");
                            cilService.addOrderCIL(omsOrderInfo);
                        }
                    }
                }else{
                    return "does not Inventory";
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return "";
    }

}
