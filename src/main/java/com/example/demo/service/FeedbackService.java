package com.example.demo.service;

import com.example.demo.dtos.ClientDto;
import com.example.demo.dtos.FeedbackDto;
import com.example.demo.dtos.ProductDto;

import java.util.List;

public interface FeedbackService {
    void addNewFeedback(FeedbackDto feedbackDto);
    void deleteFeedbackById(String feedbackId);
    List<FeedbackDto> getAllFeedbacks();
    FeedbackDto getFeedbackById(String feedbackId);
    List<FeedbackDto> getFeedbacksByClient(String username);
    List<FeedbackDto> getFeedbacksByProduct(String productTitle);

    List<ClientDto> showUsers();

    List<ProductDto> showProducts();
}
