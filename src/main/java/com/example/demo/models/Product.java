package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends BaseEntityWithCreatModif{
    private String productTitle;
    private double price;
    private String article;
    private int count;
    private Category category;
    private String image_url;
    private String description;
    private List<Order> orders;

    public Product(LocalDateTime created, LocalDateTime modified, String productTitle, double price, String article, int count, Category category, String image_url, String description, List<Order> orders) {
        super(created, modified);
        this.productTitle = productTitle;
        this.price = price;
        this.article = article;
        this.count = count;
        this.category = category;
        this.image_url = image_url;
        this.description = description;
        this.orders = orders;
    }

    public Product() {
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Transient
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
