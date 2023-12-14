package dtos;

import models.Client;
import models.Product;

import java.time.LocalDateTime;

public class FeedbackDto {
    private String description;
    private LocalDateTime dateOfFeedback;
    private int rating;
    private String image_url;
    private ClientDto client;
    private ProductDto product;

    public FeedbackDto() {
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

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
