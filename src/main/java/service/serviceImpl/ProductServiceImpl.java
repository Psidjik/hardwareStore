package service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
    ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

}
