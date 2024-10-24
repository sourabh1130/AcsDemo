package com.Advatix.LoginApi.service;

import com.Advatix.LoginApi.dao.ClientDao.ProductAttributeRepo;
import com.Advatix.LoginApi.dao.ClientDao.ProductRepo;
import com.Advatix.LoginApi.dto.ProductDto;
import com.Advatix.LoginApi.entity.Product.Product;
import com.Advatix.LoginApi.entity.Product.ProductAttributeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductAttributeRepo productAttributeRepo;

    // Create a new product
    public Product createProduct(ProductDto productDto) {
        Product product=productDto.getProduct();
        Product savedProduct=productRepo.save(product);


// Get the list of product attributes
        List<ProductAttributeInfo> productAttributeInfo =productDto.getProductAttributeInfoList();

//// Check if the product attributes list is not null or empty
//        if (productAttributeInfo != null && !productAttributeInfo.isEmpty()) {
//            // Iterate through each attribute
//            for (ProductAttributeInfo attribute : productAttributeInfo) {
//                // Set the saved product as the parent reference
//                attribute.setProduct(product);
//
//                // Save each attribute using the productAttributeRepo
//                productAttributeRepo.save(attribute);
//            }
//        }


        return savedProduct;
    }




    // Fetch products by client ID
    public List<Product> findByClientId(Long clientId) {
        return productRepo.findByClientId(clientId);
    }

    // Fetch products by SKU
    public List<Product> findBySku(String sku) {
        return productRepo.findBySku(sku);
    }

    // Fetch products by user ID
    public List<Product> findByCreatedBy(Long userId) {
        return productRepo.findByCreatedBy(userId);
    }

    // Fetch product by ID
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    // Fetch all products
    public List<Product> findAll() {
        return productRepo.findAll();
    }
}
