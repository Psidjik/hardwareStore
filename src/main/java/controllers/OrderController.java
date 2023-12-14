package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.OrderService;
import service.serviceImpl.OrderServiceImpl;

@Controller
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;






@Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
