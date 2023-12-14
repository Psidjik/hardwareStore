package models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "feedback")
public class Feedback extends BaseEntity{
    private String description;
    private LocalDateTime dateOfFeedback;
    private int rating;
    private String image_url;
    private Client client;
    private Product product;

    public Feedback() {
    }

    public Feedback(String description, LocalDateTime dateOfFeedback, int rating, String image_url, Client client, Product product) {
        this.description = description;
        this.dateOfFeedback = dateOfFeedback;
        this.rating = rating;
        this.image_url = image_url;
        this.client = client;
        this.product = product;
    }


    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "feedback_date")
    public LocalDateTime getDateOfFeedback() {
        return dateOfFeedback;
    }

    public void setDateOfFeedback(LocalDateTime dateOfFeedback) {
        this.dateOfFeedback = dateOfFeedback;
    }
    @Column(name = "rating")
    public int getRating() {
        return rating;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }
    @Column(name = "image_url")
    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
