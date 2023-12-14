package service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.FeedbackService;
@Service
public class FeedbackServiceImpl implements FeedbackService {
    ModelMapper modelMapper;

    @Autowired
    public FeedbackServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
