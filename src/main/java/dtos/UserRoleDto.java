package dtos;

import models.enums.Role;

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

    @Override
    public String toString() {
        return "UserRoleDto{" +
                ", role='" + role + '\'' +
                '}';
    }
}
