package repositories;

import models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByUsername(String username);

    @Query("SELECT o.id FROM Order o JOIN o.client u WHERE u.username = :username")
    List<String> findOffers(String username);
}
