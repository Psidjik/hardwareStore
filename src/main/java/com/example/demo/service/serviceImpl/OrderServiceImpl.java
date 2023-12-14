package com.example.demo.service.serviceImpl;

import com.example.demo.dtos.ClientDto;
import com.example.demo.dtos.ProductDto;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.dtos.OrderDto;
import com.example.demo.models.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    ClientRepository clientRepository;
    ProductRepository productRepository;

    ModelMapper modelMapper;
@Autowired
    public OrderServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void createNewOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        order.setClient(clientRepository.findByUsername(orderDto.getClient()).orElseThrow());
        order.setProduct(productRepository.findByProductTitle(orderDto.getProduct()).orElseThrow());
        order.setCreated(LocalDateTime.now());
        order.setModified(LocalDateTime.now());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderDto> orders = orderRepository.findAll().stream().map(order -> modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());
        return orders;
    }

    @Override
    public void deleteOrderById(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDto> getOrdersByClient(String username) {
        List<Order> orders = orderRepository.getOrdersByClient(username);
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersByProduct(String article) {
        List<Order> orders = orderRepository.getOrdersByProduct(article);
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrderPrice(String orderId, double newPrice) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setPrice(newPrice);
            orderRepository.save(order);
            return modelMapper.map(order, OrderDto.class);
        }
        return null;
    }

    @Override
    public List<ClientDto> showUsers() {
        return clientRepository.findAll().stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> showProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }
    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
