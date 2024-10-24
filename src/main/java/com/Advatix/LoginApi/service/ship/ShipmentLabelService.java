package com.Advatix.LoginApi.service.ship;

import com.Advatix.LoginApi.dao.BoxRepo;
import com.Advatix.LoginApi.dao.Orders.CILOrderInfoRepo;
import com.Advatix.LoginApi.dao.Orders.FEPRepo;
import com.Advatix.LoginApi.dao.WarehouseRepo;
import com.Advatix.LoginApi.dao.WhBoxLabelRepo;
import com.Advatix.LoginApi.dto.BoxDto;
import com.Advatix.LoginApi.dto.OrderDetailsDto;
import com.Advatix.LoginApi.dto.ship.*;
import com.Advatix.LoginApi.entity.Order.FEPOrderInfo;
import com.Advatix.LoginApi.entity.Order.OmsOrderInfo;
import com.Advatix.LoginApi.entity.Warehouse.Box;
import com.Advatix.LoginApi.entity.Warehouse.WhBoxLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ShipmentLabelService {
    @Autowired
    private BoxRepo boxRepo;

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

    // Method to update box details from BoxDto
    public Box setOrderDetailsByBoxID(Long id, BoxDto boxDto) {
        Optional<Box> saveBox = boxRepo.findById(id);

        if (saveBox.isEmpty()) {
            throw new RuntimeException("Box not found");
        }

        Box box = saveBox.get(); // Get the existing box entity

        // Updating the box entity with the details from BoxDto
        box.setOrderNumber(boxDto.getOrderNumber());
        box.setBoxId(boxDto.getId());
        box.setWeight(boxDto.getWeight());
//        box.setBoxDimensions(boxDto.getBoxDimensions());
        box.setLength(boxDto.getBoxDimensions().getLength());
        box.setHeight(boxDto.getBoxDimensions().getHeight());
        box.setWidth(boxDto.getBoxDimensions().getWidth());
        // Save the updated box entity back to the database
        boxRepo.save(box);



        return box;
    }

    public ResponseEntity<?> resttemp(Long id){
        try{
            RestTemplate restTemplate=new RestTemplate();
            URI uri=new URI("https://apisandbox.tusklogistics.com/v1/labels");
            System.out.println("hello");
            OrderDetailsDto orderDetailsDto=getOrderDetailsByBoxLabel(id);
            System.out.println("hii");
            AddressFrom addressFrom=new AddressFrom();
            AddressTo addressTo=new AddressTo();
            List<Parcel> parcelList=new ArrayList<>();

            addressFrom.setCity(orderDetailsDto.getShipFromCity());
            addressFrom.setCompany("Enterprise");
            addressFrom.setEmail("sourabhruhil3@gmail.com");
            addressFrom.setName(orderDetailsDto.getShipFromName());
            addressFrom.setState(orderDetailsDto.getShipFromState());
            addressFrom.setPostalCode(String.valueOf(orderDetailsDto.getShipFromPostalCode()));
            addressFrom.setPhone("27949373883");
            addressFrom.setIsResidential(orderDetailsDto.getShipFromIsResidential());
            addressFrom.setStreet1(orderDetailsDto.getShipFromAddress1());
            addressFrom.setStreet2(orderDetailsDto.getShipFromAddress2());

            addressTo.setCity(orderDetailsDto.getShipToCity());
            addressTo.setState(orderDetailsDto.getShipToState());
            addressTo.setCountry(orderDetailsDto.getShipToCountry());
            addressTo.setName(orderDetailsDto.getShipToName());
            addressTo.setStreet1(orderDetailsDto.getShipToAddress1());
            addressTo.setStreet2(orderDetailsDto.getShipToAddress2());
            addressTo.setPostalCode(String.valueOf(orderDetailsDto.getShipToPostalCode()));
            addressTo.setPhone("84493839292");
            addressTo.setEmail("jackson123@gmai.com");
            addressTo.setCompany("mcDonald");
            addressTo.setIsResidential(orderDetailsDto.getShipToIsResidential());

            Optional<Box> box=boxRepo.findById(orderDetailsDto.getBoxId());

            Weight weight=new Weight();
            Dimensions dimensions=new Dimensions();
            weight.setUnit("Ounce");
            weight.setValue(box.get().getWeight());
            dimensions.setHeight(box.get().getHeight());
            dimensions.setLength(box.get().getLength());
            dimensions.setWidth(box.get().getWidth());

            Shipment shipment=new Shipment();
            for(int i=0;i<1;i++){
                Parcel parcel=new Parcel();
                parcel.setDimensions(dimensions);
                parcel.setWeight(weight);
                parcelList.add(parcel);
            }
            shipment.setParcels(parcelList);
            shipment.setAddressFrom(addressFrom);
            shipment.setAddressTo(addressTo);
            shipment.setExternalReference("testorder_x13");


            HttpHeaders headers=new HttpHeaders();
            headers.set("Content-Type","application/json");
            headers.set("x-api-key", "7Du28nKx66p6PloG9iGz9Vbg9PZINZCuIUXdahH5");

            ShipmentLabel shipmentLabel=new ShipmentLabel();
            shipmentLabel.setShipment(shipment);
            HttpEntity<ShipmentLabel> httpEntity=new HttpEntity<>(shipmentLabel,headers);
            ResponseEntity<ShipmentResponse> response=restTemplate.postForEntity(uri,httpEntity,ShipmentResponse.class);
            ShipmentResponse shipmentResponse=new ShipmentResponse();
            return new ResponseEntity<>(shipmentResponse, HttpStatus.OK);



        }
        catch (Exception e){
            System.out.println(e);

        }
        return new ResponseEntity<>("hii",HttpStatus.OK);
    }


}


