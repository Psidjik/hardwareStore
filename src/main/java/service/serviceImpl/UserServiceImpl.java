package service.serviceImpl;


import dtos.ClientDto;
import dtos.views.ClientViewModel;
import models.Client;
import models.UserRole;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;
import repositories.UserRoleRepository;
import service.UserService;

import java.time.LocalDateTime;
import java.util.List;
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
        Client user = modelMapper.map(clientDto, Client.class);
        user.setRole(userRoleRepository.findUserRoleByRole(clientDto.getRole()).orElseThrow());
        user.setIs_active(true);
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        clientRepository.saveAndFlush(user);
    }

    @Override
    public ClientViewModel getUserById(String id) {
        return modelMapper.map(clientRepository.findById(id), ClientViewModel.class);
    }

    @Override
    public List<UserRole> showAllRole(){
        return userRoleRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(String id) {
        clientRepository.deleteById(id);
    }

//    @Override
//    public List<UserViewModel> getAllUserByUsername(String username) {
//        return userRepository.findAllByUsername(username).stream().map(user -> modelMapper.map(user,UserViewModel.class)).collect(Collectors.toList());
//    }

    @Override
    public ClientDto updateUserFirstName(String id, String firstName) {
        Client user = clientRepository.findById(id).orElseThrow();
        user.setFirstName(firstName);
        clientRepository.save(user);
        return modelMapper.map(user, ClientDto.class);
    }

    @Override
    public List<String> getOffersByUsername(String username) {
        return clientRepository.findOffers(username);
    }

    @Override
    public ClientDto getUserByUsername(String username) {
        return modelMapper.map(clientRepository.findByUsername(username), ClientDto.class);
    }



    @Override
    public List<ClientViewModel> getAllUser() {
        return clientRepository.findAll().stream().map(user -> modelMapper.map(user,ClientViewModel.class)).collect(Collectors.toList());
    }
@Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
@Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }
}
