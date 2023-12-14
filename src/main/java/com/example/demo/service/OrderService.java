package com.example.demo.service;

import com.example.demo.dtos.ClientDto;
import com.example.demo.dtos.ProductDto;
import com.example.demo.dtos.OrderDto;

import java.util.List;

public interface OrderService {
    void createNewOrder(OrderDto orderDto);
    List<OrderDto> getAllOrders();
    void deleteOrderById(String id);
    List<OrderDto> getOrdersByClient(String username);
    List<OrderDto> getOrdersByProduct(String article);
    OrderDto updateOrderPrice(String orderId, double newPrice);

    List<ClientDto> showUsers();

    List<ProductDto> showProducts();
}
