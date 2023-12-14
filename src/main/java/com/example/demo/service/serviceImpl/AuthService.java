package com.example.demo.service.serviceImpl;

import com.example.demo.dtos.UserRegistrationDto;
import com.example.demo.models.Client;
import com.example.demo.models.enums.Role;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private ModelMapper modelMapper;
@Autowired
    private PasswordEncoder passwordEncoder;


    public void register(UserRegistrationDto registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }

        Optional<Client> byUserName = this.clientRepository.findByUsername(registrationDTO.getUsername());

        if (byUserName.isPresent()) {
            throw new RuntimeException("username.used");
        }

        var userRole = userRoleRepository.findByRole(Role.CLIENT).orElseThrow();

        Client user = modelMapper.map(registrationDTO, Client.class);
        user.setRole(userRole);
        user.setIs_active(true);
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        clientRepository.saveAndFlush(user);
    }

    public Client getUser(String username) {
        return clientRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}
