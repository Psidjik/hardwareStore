package com.example.demo.dtos;

public class OrderDto {
    private String id;
    private String client;
    private String product;
    private double price;


    public OrderDto(String id, String client, String product, double price) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.price = price;
    }

    public OrderDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id='" + id + '\'' +
                ", client='" + client + '\'' +
                ", product='" + product + '\'' +
                ", price=" + price +
                '}';
    }
}
