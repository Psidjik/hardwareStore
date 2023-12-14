package com.example.demo.repositories;

import com.example.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByUsername(String username);

}
