package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import com.example.demo.models.enums.Role;
import org.hibernate.validator.constraints.Length;

public class ClientDto {
    private Role role;
    private boolean is_active;
    private String firstName;
    private String last_name;
    private String password;
    private String username;
    private String phoneNumber;


    public ClientDto(Role role,
                   boolean is_active, String firstName, String last_name, String password, String username, String phoneNumber) {
        this.role = role;
        this.is_active = is_active;
        this.firstName = firstName;
        this.last_name = last_name;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public ClientDto() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @NotBlank(message = "firstName cannot be empty")
    @Length(min = 2, message = "firstName must be more than two characters")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //    @NotBlank(message = "ImageURL cannot be empty")
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
    @NotBlank(message = "LastName cannot be empty")
    @Length(min = 2, message = "LastName must be more than two characters")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @NotBlank(message = "The password cannot be empty")
    @Length(min = 2, message = "Password must be more than two characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotBlank(message = "username cannot be empty")
    @Length(min = 2, message = "Username must be more than two characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                ", role=" + role +
                ", is_active=" + is_active +
                ", firstName='" + firstName + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
