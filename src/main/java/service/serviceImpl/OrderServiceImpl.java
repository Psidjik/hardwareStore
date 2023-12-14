package service.serviceImpl;

import dtos.ClientDto;
import dtos.OrderDto;
import dtos.ProductDto;
import models.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.OrderRepository;
import repositories.ProductRepository;
import service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    ClientRepository clientRepository;
    ProductRepository productRepository;


    ModelMapper modelMapper;
    @Override
    public void createNewOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
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


}
