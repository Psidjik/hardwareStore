package service.serviceImpl;

import dtos.CategoryDto;
import dtos.ProductDto;
import models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CategoryRepository;
import repositories.ProductRepository;
import service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    ModelMapper modelMapper;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }





    @Override
    public void addNewProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        productRepository.save(product);
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
}
