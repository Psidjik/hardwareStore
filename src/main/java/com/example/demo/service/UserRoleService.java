package com.example.demo.service;


import com.example.demo.models.enums.Role;
import com.example.demo.dtos.UserRoleDto;

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
