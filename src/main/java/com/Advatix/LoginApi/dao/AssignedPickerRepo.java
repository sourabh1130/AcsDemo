package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.Warehouse.AssignedPicker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedPickerRepo extends JpaRepository<AssignedPicker, Long> {
}
