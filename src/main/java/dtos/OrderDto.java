package dtos;

import models.Client;
import models.Product;

public class OrderDto {
    private ClientDto client;
    private ProductDto product;
    private double price;

    public OrderDto(ClientDto client, ProductDto product, double price) {
        this.client = client;
        this.product = product;
        this.price = price;
    }

    public OrderDto() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
