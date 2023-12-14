package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BaseEntityWithCreatModif{
private Client client;
private Product product;
private double price;

    public Order(LocalDateTime created, LocalDateTime modified, Client client, Product product, double price) {
        super(created, modified);
        this.client = client;
        this.product = product;
        this.price = price;
    }

    public Order() {
    }
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", product=" + product +
                ", price=" + price +
                '}';
    }
}
