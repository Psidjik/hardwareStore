package com.example.demo.repositories;

import com.example.demo.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String> {

    @Query("SELECT f FROM Feedback f WHERE f.client.username = :username")
    List<Feedback> findFeedbacksByClientUsername(String username);

    @Query("SELECT f FROM Feedback f WHERE f.product.productTitle = :productTitle")
    List<Feedback> findFeedbacksByProductTitle(String productTitle);
}
