package com.Advatix.LoginApi.dto;

import com.Advatix.LoginApi.entity.Product.Product;
import com.Advatix.LoginApi.entity.Product.ProductAttributeInfo;
import lombok.Data;

import java.util.List;

@Data

public class ProductDto {
    private Product product;
    private List<ProductAttributeInfo> productAttributeInfoList;
}

//{"product":{},"productAttributeInfoList":[{}] }
