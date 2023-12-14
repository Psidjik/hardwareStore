package repositories;

import models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, String> {

    @Query("SELECT f FROM Feedback f WHERE f.client.username = :username")
    List<Feedback> findFeedbacksByClientUsername(String username);

    @Query("SELECT f FROM Feedback f WHERE f.product.productTitle = :productTitle")
    List<Feedback> findFeedbacksByProductTitle(String productTitle);
}
