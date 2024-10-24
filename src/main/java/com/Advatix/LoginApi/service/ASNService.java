package com.Advatix.LoginApi.service;
import com.Advatix.LoginApi.dao.ASNUnitRepo;
import com.Advatix.LoginApi.dao.ASSNoticeRepo;
import com.Advatix.LoginApi.dao.ClientDao.ProductRepo;
import com.Advatix.LoginApi.dao.UserRepo;
import com.Advatix.LoginApi.dao.WarehouseRepo;
import com.Advatix.LoginApi.dto.ASNNoticeRequestDto;
import com.Advatix.LoginApi.dto.ASNUnitRequest;
import com.Advatix.LoginApi.entity.Product.Product;
import com.Advatix.LoginApi.entity.Shipment.ASNNotice;
import com.Advatix.LoginApi.entity.Shipment.ASNUnits;
import com.Advatix.LoginApi.entity.Warehouse.WarehouseRecivedItems;
import com.Advatix.LoginApi.entity.Warehouse.enums.InventoryStage;
import com.Advatix.LoginApi.entity.Warehouse.enums.ReceiveStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ASNService {

    @Autowired
    ASSNoticeRepo assNoticeRepo;

    @Autowired
    ASNUnitRepo asnUnitRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;

   @Autowired
   WarehouseRepo warehouseRepo;


    public ASNNotice addASN(ASNNoticeRequestDto asnNoticeRequest) {
        ASNNotice asnNotice = new ASNNotice();
//        WarehouseRecivedItems warehouseReceivedItems = new WarehouseRecivedItems();

        asnNotice.setPoNumber(asnNoticeRequest.getPoNumber());
        asnNotice.setLotNumber(asnNoticeRequest.getLotNumber());
        asnNotice.setTotalQuantity(asnNoticeRequest.getTotalQuantity());
        asnNotice.setCreatedOn(LocalDate.now());
        asnNotice.setUser(userRepo.findById(asnNoticeRequest.getCreatedBy()).get());


        List<ASNUnits> asnUnitsList = new ArrayList<>();
        List<WarehouseRecivedItems> warehouseReceivedItemsList = new ArrayList<>();
        for (ASNUnitRequest asnUnit : asnNoticeRequest.getAsnUnitList()) {

            ASNUnits unit = new ASNUnits(asnUnit.getQuantity(), asnUnit.getReceivedQuantity(), asnUnit.getLocation(), (Product) productRepo.findByCreatedBy((long) asnUnit.getProductId().intValue()));
            asnUnitsList.add(unit);

           WarehouseRecivedItems warehouseReceivedItems=new WarehouseRecivedItems();

            warehouseReceivedItems.setWarehouseId(asnNoticeRequest.getWarehouseId());
            warehouseReceivedItems.setLocationBarcode(asnUnit.getLocation());
            warehouseReceivedItems.setClientId(unit.getProduct().getClientId());
            warehouseReceivedItems.setEmployeeId(asnNoticeRequest.getCreatedBy());
            warehouseReceivedItems.setQuantity(asnUnit.getReceivedQuantity());
            warehouseReceivedItems.setProductId(asnUnit.getProductId());
            warehouseReceivedItems.setCreatedOn(LocalDate.now());
            warehouseReceivedItems.setLotNumber(asnNoticeRequest.getLotNumber());

            warehouseReceivedItems.setInventoryStage(InventoryStage.ON_HAND);
            warehouseReceivedItems.setReceiveStatus(ReceiveStatus.RECEIVED);

            warehouseRepo.save(warehouseReceivedItems);
        }
        asnNotice.setAsnUnitsList(asnUnitsList);  // set the saved ASNNotice with its units
        ASNNotice savedNotice = assNoticeRepo.save(asnNotice);  // Save ASNNotice to return

        return savedNotice;
    }
}

