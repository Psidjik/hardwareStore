package service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
    ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
