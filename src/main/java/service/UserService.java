package service;

import dtos.*;

import java.util.List;

public interface UserService {
    void addNewUser(ClientDto clientDto);
    void deleteUserByUsername(String username);
    List<ClientDto> getAllUser();
    ClientDto updateUserUserName(String username, String newUsername);
    ClientDto getUserByUsername(String username);
    List<UserRoleDto> showRole();
}
