package repositories;

import models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    @Query("SELECT c FROM Category c JOIN c.products p WHERE p.productTitle = :productTitle")
    List<Category> getCategoriesByProductTitle(String productTitle);

    Optional<Category> findByCategoryTitle(String categoryTitle);
}
