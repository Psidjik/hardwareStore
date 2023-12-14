package com.example.demo.service.serviceImpl;

import com.example.demo.dtos.ClientDto;
import com.example.demo.dtos.FeedbackDto;
import com.example.demo.dtos.ProductDto;
import com.example.demo.models.Client;
import com.example.demo.models.Feedback;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.FeedbackRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.FeedbackService;

import java.time.LocalDateTime;
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
        Optional<Client> optionalClient = clientRepository.findByUsername(feedbackDto.getClient());
        Optional<Product> optionalProduct = productRepository.findByProductTitle(feedbackDto.getProduct());
        feedback.setDateOfFeedback(LocalDateTime.now());
        optionalClient.ifPresent(feedback::setClient);
        optionalProduct.ifPresent(feedback::setProduct);

        feedbackRepository.saveAndFlush(feedback);
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

