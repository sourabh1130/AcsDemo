package com.Advatix.LoginApi.dao.ClientDao;

import com.Advatix.LoginApi.entity.Product.ProductAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeRepo extends JpaRepository<ProductAttributes,Long> {
}
