package service;

import dtos.ClientDto;
import dtos.views.ClientViewModel;
import models.UserRole;

import java.util.List;

public interface UserService {
    void addNewUser(ClientDto clientDto);
    List<UserRole> showAllRole();
    ClientViewModel getUserById(String id);
    void deleteUserById(String id);
//    List<UserViewModel> getAllUserByUsername(String username);
    List<ClientViewModel> getAllUser();
    ClientDto updateUserFirstName(String id, String firstName);

    List<String> getOffersByUsername(String username);

    ClientDto getUserByUsername(String username);
}
