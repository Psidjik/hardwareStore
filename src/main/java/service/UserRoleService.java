package service;


import dtos.UserRoleDto;
import models.enums.Role;

import java.util.List;

public interface UserRoleService {
    void addNewUserRole(UserRoleDto userRoleDto);
    UserRoleDto getUserRoleById(String id);
    void deleteUserRoleById(String id);
    List<UserRoleDto> getAllUserRole();
    List<UserRoleDto> getAllUserRoleByName(String name);
    UserRoleDto updateUserRoleName(String id, Role role);

    List<UserRoleDto> getAllUserRoles();
}
