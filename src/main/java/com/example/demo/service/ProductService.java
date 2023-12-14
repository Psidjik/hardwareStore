package com.example.demo.service;

import com.example.demo.dtos.CategoryDto;
import com.example.demo.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    void addNewProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductByProductTitle(String productTitle);
    ProductDto updateProductCount(String productTitle, int newCount);
    void deleteProductByProductTitle(String productTitle);

    List<CategoryDto> showCategory();
}
