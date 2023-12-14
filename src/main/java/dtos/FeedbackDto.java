package dtos;

import models.Client;
import models.Product;

import java.time.LocalDateTime;

public class FeedbackDto {
    private String description;
    private LocalDateTime dateOfFeedback;
    private int rating;
    private String image_url;
    private Client client;
    private ProductDto product;

}
