package service.serviceImpl;

import dtos.ClientDto;
import dtos.FeedbackDto;
import dtos.ProductDto;
import models.Client;
import models.Feedback;
import models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.FeedbackRepository;
import repositories.ProductRepository;
import service.FeedbackService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    FeedbackRepository feedbackRepository;
    ClientRepository clientRepository;
    ProductRepository productRepository;
    ModelMapper modelMapper;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, ClientRepository clientRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.feedbackRepository = feedbackRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addNewFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = modelMapper.map(feedbackDto, Feedback.class);
        Optional<Client> optionalClient = clientRepository.findByUsername(feedbackDto.getClient().getUsername());
        Optional<Product> optionalProduct = productRepository.findByProductTitle(feedbackDto.getProduct().getProductTitle());

        optionalClient.ifPresent(feedback::setClient);
        optionalProduct.ifPresent(feedback::setProduct);

        feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedbackById(String feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }

    @Override
    public List<FeedbackDto> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return feedbacks.stream()
                .map(feedback -> modelMapper.map(feedback, FeedbackDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackDto getFeedbackById(String feedbackId) {
        Optional<Feedback> optionalFeedback = feedbackRepository.findById(feedbackId);
        return optionalFeedback.map(feedback -> modelMapper.map(feedback, FeedbackDto.class)).orElse(null);
    }

    @Override
    public List<FeedbackDto> getFeedbacksByClient(String username) {
        List<Feedback> feedbacks = feedbackRepository.findFeedbacksByClientUsername(username);
        return feedbacks.stream()
                .map(feedback -> modelMapper.map(feedback, FeedbackDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FeedbackDto> getFeedbacksByProduct(String productTitle) {
        List<Feedback> feedbacks = feedbackRepository.findFeedbacksByProductTitle(productTitle);
        return feedbacks.stream()
                .map(feedback -> modelMapper.map(feedback, FeedbackDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> showUsers() {
        return clientRepository.findAll().stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> showProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }


}

