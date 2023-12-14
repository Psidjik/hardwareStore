package service;

import dtos.CategoryDto;

import java.util.List;

public interface CategoryService {
    void addNewCategory(CategoryDto categoryDto);
    void deleteCategoryByTitle(String categoryTitle);
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryByTitle(String categoryTitle);
    List<CategoryDto> getCategoriesByProductTitle(String productTitle);
}
