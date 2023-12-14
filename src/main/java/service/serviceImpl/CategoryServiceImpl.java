package service.serviceImpl;

import dtos.CategoryDto;
import models.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CategoryRepository;
import repositories.ProductRepository;
import service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    ProductRepository productRepository;

    ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addNewCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public void deleteCategoryByTitle(String categoryTitle) {
        Optional<Category> optionalCategory = categoryRepository.findByCategoryTitle(categoryTitle);
        optionalCategory.ifPresent(category -> categoryRepository.deleteById(category.getId()));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryByTitle(String categoryTitle) {
        Optional<Category> optionalCategory = categoryRepository.findByCategoryTitle(categoryTitle);
        return optionalCategory.map(category -> modelMapper.map(category, CategoryDto.class)).orElse(null);
    }

    @Override
    public List<CategoryDto> getCategoriesByProductTitle(String productTitle) {
        List<Category> categories = categoryRepository.getCategoriesByProductTitle(productTitle);
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
