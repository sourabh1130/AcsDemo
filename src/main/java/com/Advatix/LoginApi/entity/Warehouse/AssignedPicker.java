package com.Advatix.LoginApi.entity.Warehouse;

import com.Advatix.LoginApi.entity.Warehouse.enums.PickerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "whOrderContainerAssignment")
public class AssignedPicker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "assignedBy")
    private String pickerName;
    private LocalDate createdOn;
    @Column(name = "assignedOn")
    private LocalDate updatedOn;
    private Long orderId;
    @Enumerated(EnumType.STRING)
    private PickerStatus pickerStatus;
    private Long containerId;
    private Long productId;
    private Integer quantity;


    public void setOrderId(Long orderId) {
    }

}
