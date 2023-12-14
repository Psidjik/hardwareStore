package service.serviceImpl;

import dtos.UserRegistrationDto;
import models.Client;
import models.enums.Role;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.UserRoleRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    private ClientRepository clientRepository;
    private UserRoleRepository userRoleRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public AuthService(ClientRepository clientRepository, UserRoleRepository userRoleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

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
        clientRepository.saveAndFlush(user);

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        this.clientRepository.saveAndFlush(user);
    }

    public Client getUser(String username) {
        return clientRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}
