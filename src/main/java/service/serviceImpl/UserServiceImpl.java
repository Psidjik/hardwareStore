package service.serviceImpl;


import dtos.ClientDto;
import dtos.UserRoleDto;
import models.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.UserRoleRepository;
import service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    ClientRepository clientRepository;
    UserRoleRepository userRoleRepository;
    ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public void addNewUser(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        clientRepository.save(client);
    }

    @Override
    public void deleteUserByUsername(String username) {
        Optional<Client> optionalClient = clientRepository.findByUsername(username);
        optionalClient.ifPresent(client -> clientRepository.deleteById(client.getId()));
    }

    @Override
    public List<ClientDto> getAllUser() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto updateUserUserName(String username, String newUsername) {
        Optional<Client> optionalClient = clientRepository.findByUsername(username);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setUsername(newUsername);
            clientRepository.save(client);
            return modelMapper.map(client, ClientDto.class);
        }
        return null;
    }

    @Override
    public ClientDto getUserByUsername(String username) {
        Optional<Client> optionalClient = clientRepository.findByUsername(username);
        return optionalClient.map(client -> modelMapper.map(client, ClientDto.class)).orElse(null);
    }

    @Override
    public List<UserRoleDto> showRole() {
        return userRoleRepository.findAll().stream().map(userRole -> modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }
}
