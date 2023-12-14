package service;

import dtos.CategoryDto;
import dtos.ClientDto;
import dtos.ProductDto;
import dtos.views.ClientViewModel;
import models.Category;
import models.UserRole;

import java.util.List;

public interface ProductService {
    void addNewProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductByProductTitle(String productTitle);
    ProductDto updateProductCount(String productTitle, int newCount);
    void deleteProductByProductTitle(String productTitle);

    List<CategoryDto> showCategory();
}
