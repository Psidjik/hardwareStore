package dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class UserRegistrationDto {
    private String username;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String password;
    private String confirmPassword;

    @NotEmpty(message = "The username cannot be empty")
    @Length(min = 2, message = "Username must be more than two characters and not use special characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty(message = "The password cannot be empty")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotNull
    @NotEmpty(message = "The firstName cannot be empty")
    @Length(min = 2, message = "The firstName must be more than two characters and not use special characters!")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @NotNull
    @NotEmpty(message = "The lastName cannot be empty")
    @Length(min = 2, message = "The lastName must be more than two characters and not use special characters!")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @NotEmpty(message = "Confirm Password cannot be null or empty!")
    @Size(min = 5, max = 20)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
