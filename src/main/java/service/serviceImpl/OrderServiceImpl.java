package service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
    ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
