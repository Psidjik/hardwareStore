package com.example.demo.service.serviceImpl;

import com.example.demo.dtos.CategoryDto;
import com.example.demo.dtos.ProductDto;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    ModelMapper modelMapper;

    public ProductServiceImpl( ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void addNewProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product.setCategory(categoryRepository.findByCategoryTitle(productDto.getCategory()).orElseThrow());
        product.setCreated(LocalDateTime.now());
        product.setModified(LocalDateTime.now());
        productRepository.saveAndFlush(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductByProductTitle(String productTitle) {
        Optional<Product> optionalProduct = productRepository.findByProductTitle(productTitle);
        return optionalProduct.map(product -> modelMapper.map(product, ProductDto.class)).orElse(null);
    }

    @Override
    public ProductDto updateProductCount(String productTitle, int newCount) {
        Optional<Product> optionalProduct = productRepository.findByProductTitle(productTitle);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setCount(newCount);

            productRepository.save(existingProduct);
            return modelMapper.map(existingProduct, ProductDto.class);
        }
        return null;
    }

    @Override
    public void deleteProductByProductTitle(String productTitle) {
        Optional<Product> optionalProduct = productRepository.findByProductTitle(productTitle);
        optionalProduct.ifPresent(product -> productRepository.deleteById(product.getId()));
    }

    @Override
    public List<CategoryDto> showCategory() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }
@Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
@Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
