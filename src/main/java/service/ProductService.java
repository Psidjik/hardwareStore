package service;

import dtos.ClientDto;
import dtos.ProductDto;
import dtos.views.ClientViewModel;
import models.Category;
import models.UserRole;

import java.util.List;

public interface ProductService {
    void addNewProduct(ProductDto productDto);
    List<Category> showAllCategories();
//    ProductDto getProductById(String id);
    void deleteUserByProductTitle(String productTitle);
    List<ProductDto> getAllProduct();
//    ClientDto updateUserFirstName(String id, String firstName);

//    List<String> getOffersByUsername(String username);

    ProductDto getProductByProductTitle(String productTitle);
}
