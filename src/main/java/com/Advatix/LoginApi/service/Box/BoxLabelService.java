package com.Advatix.LoginApi.service.Box;

import com.Advatix.LoginApi.dao.Orders.CILOrderInfoRepo;
import com.Advatix.LoginApi.dao.WarehouseRepo;
import com.Advatix.LoginApi.dao.WhBoxLabelRepo;
import com.Advatix.LoginApi.dto.BoxDto;
import com.Advatix.LoginApi.entity.Warehouse.WhBoxLabel;
import com.Advatix.LoginApi.entity.Warehouse.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.Advatix.LoginApi.entity.Warehouse.enums.OrderStatus.ACTIVE;

@Service
public class BoxLabelService {

    @Autowired
    private WhBoxLabelRepo whBoxLabelRepo;

    // Fetch all active boxes
//    public List<WhBoxLabel> getActiveBoxes() {
//        return whBoxLabelRepo.findByBoxStatus(OrderStatus.ACTIVE);
//    }
    public List<WhBoxLabel> getActiveBoxes() {
        return whBoxLabelRepo.findByBoxStatus(OrderStatus.ACTIVE);  // Use the correct case
    }

    // Print all box labels
    public void printBoxLabels(List<WhBoxLabel> boxes) {
        boxes.forEach(this::printBoxDetails);
    }
    // Method to print box details
    private void printBoxDetails(WhBoxLabel box) {
        System.out.println("Warehouse ID: " + box.getWarehouseId() +
                ", Box Type: " + box.getBoxType() +
                ", Box ID: " + box.getId() +
                ", Status: " + box.getStatus());
    }


    public List<String> getPrintedBoxLabels(List<WhBoxLabel> boxes) {
        return boxes.stream()
                .map(box -> "Warehouse ID: " + box.getWarehouseId() +
                        ", Box Type: " + box.getBoxType() +
                        ", Box ID: " + box.getId() +
                        ", Status: " + box.getStatus())
                .collect(Collectors.toList());
    }
    public List<Long> printBoxLabel(BoxDto boxDto){
        List<Long> boxIdList = new ArrayList<>();

        List<WhBoxLabel> availableBox = whBoxLabelRepo.findByWarehouseIdAndBoxTypeAndBoxStatus(boxDto.getWarehouseId(), boxDto.getBoxType(), OrderStatus.ACTIVE);


        if(availableBox.isEmpty() || boxDto.getQuantity()<=0){
            System.out.println("Quantity must be greater than Zero");
            System.out.println("No box available now");
        } else if (availableBox.size() < boxDto.getQuantity()) {
            System.out.println("Quantity Exceeded");

            //iterating over the given list
            //And at least providing the available boxes
            for (WhBoxLabel box : availableBox) {

                //adding the box id to result list
                boxIdList.add(box.getId());
                //setting up the box status to inactive
//                box.setOrderStatus(OrderStatus.INACTIVE);
                box.setBoxStatus(OrderStatus.INACTIVE);
                whBoxLabelRepo .save(box);
            }
        }
        else{
            System.out.println("Allocating number of boxes");

            //iterating over the given list till the required no of boxes allotted
            for(int i =0; i<boxDto.getQuantity(); i++){

                WhBoxLabel boxLabel = availableBox.get(i);
                //adding box id to result list
                boxIdList.add(boxLabel.getId());
                //setting up the box status to inactive
                boxLabel.setBoxStatus(OrderStatus.INACTIVE);
//                boxLabel.setOrderStatus(OrderStatus.INACTIVE);

                whBoxLabelRepo.save(boxLabel);
            }
        }
        return boxIdList;
    }
}

