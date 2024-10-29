package com.Advatix.LoginApi.service.Box;

import com.Advatix.LoginApi.dao.AssignedPickerRepo;
import com.Advatix.LoginApi.dao.Orders.CILOrderInfoRepo;
import com.Advatix.LoginApi.dao.Orders.FEPRepo;
import com.Advatix.LoginApi.dto.AssignedPickerDto;
import com.Advatix.LoginApi.dto.OrderContainerDto;
import com.Advatix.LoginApi.dto.OrderProductDto;
import com.Advatix.LoginApi.dto.PickerUserDto;
import com.Advatix.LoginApi.entity.Order.OmsOrderInfo;
import com.Advatix.LoginApi.entity.Order.OmsOrderItems;
import com.Advatix.LoginApi.entity.Warehouse.AssignedPicker;
import com.Advatix.LoginApi.entity.Warehouse.enums.MasterStatus;
import com.Advatix.LoginApi.entity.Warehouse.enums.PickerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class OrderFilterService {
    @Autowired
    private CILOrderInfoRepo cilOrderInfoRepo;

    @Autowired
    private FEPRepo fepRepo;

    @Autowired
    private AssignedPickerRepo assignedPickerRepo;

    // Method to get the list of products by order number (as Long)
    public List<OrderProductDto> getProductsByOrderNumber(Long orderNumber) {
        List<OmsOrderInfo> orders = cilOrderInfoRepo.findByOrderNumber(orderNumber);
        List<OrderProductDto> orderProductDtos = new ArrayList<>();

        // Loop through each order and extract the productId from orderItems
        for (OmsOrderInfo order : orders) {
            for (OmsOrderItems item : order.getOrderItemsList()) {
                orderProductDtos.add(new OrderProductDto(order.getOrderId(), item.getProductId()));
            }
        }

        return orderProductDtos;
    }
    public List<Long> getProductIdsByOrderId(Long orderId) {
        Optional<OmsOrderInfo> orderInfo = cilOrderInfoRepo.findByOrderId(orderId);

        if (orderInfo.isEmpty() || orderInfo.get().getOrderItemsList() == null) {
            return List.of();
        }

        List<OmsOrderItems> orderItemsList = orderInfo.get().getOrderItemsList();
        List<Long> productIds = new ArrayList<>();

        for (OmsOrderItems item : orderItemsList) {
            productIds.add(item.getProductId());
        }

        return productIds;
    }


//
public ResponseEntity<?> assignPicker(AssignedPickerDto assignedPickerDto){
    if (assignedPickerDto.getOrderId() == null || assignedPickerDto.getPickerName() == null) {
        return new ResponseEntity<>("Order ID and Picker Name must not be null", HttpStatus.BAD_REQUEST);
    }

    // Verifying oderId is present or not in db

    Optional<OmsOrderInfo> optionalFepOrdersInfo = cilOrderInfoRepo.findByOrderId(assignedPickerDto.getOrderId());
    if (!optionalFepOrdersInfo.isPresent()) {
        return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
    }

    AssignedPicker assignedPicker = new AssignedPicker();

    assignedPicker.setPickerName(assignedPickerDto.getPickerName());
    assignedPicker.setOrderId(assignedPickerDto.getOrderId());
    assignedPicker.setPickerStatus(PickerStatus.ASSIGNED);
    assignedPicker.setCreatedOn(LocalDate.now());
    assignedPicker.setUpdatedOn(LocalDate.now());
    assignedPickerRepo.save(assignedPicker);

    OmsOrderInfo fepOrdersInfo = optionalFepOrdersInfo.get();
    fepOrdersInfo.setStatus(MasterStatus.Assigned);
    cilOrderInfoRepo.save(fepOrdersInfo);

    return new ResponseEntity<>("Picker Assigned Successfully",HttpStatus.CREATED);
}

    public ResponseEntity<?> submitPickList(OrderContainerDto orderContainerDto){
        if (orderContainerDto.getOrderId() == null || orderContainerDto.getPickerName() == null) {
            return new ResponseEntity<>("Order ID and Picker Name must not be null", HttpStatus.BAD_REQUEST);
        }

        // Verifying oderId is present or not in db

        Optional<OmsOrderInfo> optionalFepOrdersInfo = cilOrderInfoRepo.findByOrderId(orderContainerDto.getOrderId());
        if (!optionalFepOrdersInfo.isPresent()) {
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }
        //Map<ProductId, Quantity>
        Map<Long, Long> fepItemMap = new HashMap<>();

        for(OmsOrderItems fepOrdersItem : optionalFepOrdersInfo.get().getOrderItemsList()) {
            fepItemMap.put(fepOrdersItem.getProductId(), fepOrdersItem.getProductQty());
        }


        for (Long productId : fepItemMap.keySet()){
            Long currentProductQty = 0L;
            for(PickerUserDto pickerUserDto : orderContainerDto.getPickerUserDtoList()) {
                if(pickerUserDto.getProductId() == productId){
                    currentProductQty += pickerUserDto.getQuantity();
                }
            }
            if (!fepItemMap.get(productId).equals(currentProductQty)){
                return new ResponseEntity<>("Product quantity mismatched : " + productId, HttpStatus.NOT_FOUND);
            }
        }

        for(PickerUserDto pickerUserDto : orderContainerDto.getPickerUserDtoList()) {
            AssignedPicker assignedPicker = new AssignedPicker();

            assignedPicker.setOrderId(orderContainerDto.getOrderId());
            assignedPicker.setPickerName(orderContainerDto.getPickerName());
            assignedPicker.setCreatedOn(LocalDate.now());
            assignedPicker.setUpdatedOn(LocalDate.now());
            assignedPicker.setPickerStatus(PickerStatus.ASSIGNED);

            assignedPicker.setContainerId(pickerUserDto.getContainerId());
            assignedPicker.setProductId(pickerUserDto.getProductId());
            assignedPicker.setQuantity(pickerUserDto.getQuantity());


            OmsOrderInfo fepOrdersInfo = optionalFepOrdersInfo.get();
            fepOrdersInfo.setStatus(MasterStatus.Packed);
            cilOrderInfoRepo.save(fepOrdersInfo);

            assignedPickerRepo.save(assignedPicker);
        }
        return new ResponseEntity<>("Assigned",HttpStatus.CREATED);
    }
}
