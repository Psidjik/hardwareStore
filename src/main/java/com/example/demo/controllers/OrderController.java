package com.example.demo.controllers;

import com.example.demo.dtos.OrderDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @GetMapping("/all")
    public String showAllOrders(Model model) {
        model.addAttribute("orderInfos", orderService.getAllOrders());
        return "orders-all";
    }

    @GetMapping("/add")
    public String addOrder(Model model) {
        model.addAttribute("availableClients", orderService.showUsers());
        model.addAttribute("availableProducts", orderService.showProducts());
        return "order-add";
    }

    @ModelAttribute("orderModel")
    public OrderDto initOrder() {
        return new OrderDto();
    }

    @PostMapping("/add")
    public String addOrder(@Valid OrderDto orderDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderModel", orderDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderModel",
                    bindingResult);
            return "redirect:/order/add";
        }
        orderService.createNewOrder(orderDto);
        return "redirect:/order/all";
    }

    @GetMapping("/delete/{orderId}")
    public String deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrderById(orderId);
        return "redirect:/order/all";
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

}
