package com.example.demo.dtos;

import com.example.demo.models.enums.Role;

public class UserRoleDto {
    private Role role;

    public UserRoleDto(Role role) {
        this.role = role;
    }

    public UserRoleDto() {}

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
