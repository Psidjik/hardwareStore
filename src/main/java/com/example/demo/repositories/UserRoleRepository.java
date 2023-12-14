package com.example.demo.repositories;

import com.example.demo.models.UserRole;
import com.example.demo.models.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    UserRole findUserRoleByRole(Role role);

    Optional<UserRole> findByRole(Role role);
}
