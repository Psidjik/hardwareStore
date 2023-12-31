package com.example.demo.repositories;

import com.example.demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Query("SELECT o FROM Order o JOIN o.client c WHERE c.username = :username")
    List<Order> getOrdersByClient(String username);

    @Query("SELECT o FROM Order o JOIN o.product p WHERE p.article = :article")
    List<Order> getOrdersByProduct(String article);

}
