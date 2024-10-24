package com.Advatix.LoginApi.dao.ClientDao;

import com.Advatix.LoginApi.dto.ProductDto;
import com.Advatix.LoginApi.entity.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByClientId(Long clientId);
    List<Product> findBySku(String sku);
    List<Product> findByCreatedBy(Long userId);


}
