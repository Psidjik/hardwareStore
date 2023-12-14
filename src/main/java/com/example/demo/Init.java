package com.example.demo;

import com.example.demo.models.Client;
import com.example.demo.models.UserRole;
import com.example.demo.models.enums.Role;
import com.example.demo.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.demo.repositories.UserRoleRepository;

import java.time.LocalDateTime;
import java.util.Optional;


@Component
public class Init implements CommandLineRunner {

    private final UserRoleRepository userRoleRepository;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public Init(UserRoleRepository userRoleRepository, ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.userRoleRepository = userRoleRepository;
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        initRoles();
        initAdmin();
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            var admin = new UserRole(Role.ADMIN);
            var user = new UserRole(Role.CLIENT);
            userRoleRepository.save(admin);
            userRoleRepository.save(user);
        }
    }

    private void initAdmin() {
        if(clientRepository.count()==0) {
            UserRole admin = userRoleRepository.findUserRoleByRole(Role.ADMIN);
            Client userAdmin = new Client();
            userAdmin.setUsername("admin");
            userAdmin.setPassword(passwordEncoder.encode("admin"));
            userAdmin.setRole(admin);
            clientRepository.save(userAdmin);
        }
    }
}