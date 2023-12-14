package com.example.demo.dtos;

import java.time.LocalDateTime;

public class FeedbackDto {

    private String description;
    private LocalDateTime dateOfFeedback;
    private int rating;
    private String image_url;
    private String client;
    private String product;

    public FeedbackDto() {
    }

    public FeedbackDto(String description, LocalDateTime dateOfFeedback, int rating, String image_url, String client, String product) {
        this.description = description;
        this.dateOfFeedback = dateOfFeedback;
        this.rating = rating;
        this.image_url = image_url;
        this.client = client;
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateOfFeedback() {
        return dateOfFeedback;
    }

    public void setDateOfFeedback(LocalDateTime dateOfFeedback) {
        this.dateOfFeedback = dateOfFeedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
