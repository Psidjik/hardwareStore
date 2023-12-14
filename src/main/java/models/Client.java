package models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends BaseEntityWithCreatModif{
    private List<Order> orders;
    private UserRole role;
    private boolean is_active;
    private String firstName;
    private String last_name;
    private String password;
    private String username;
    private String phoneNumber;
    private List<Feedback> feedbacks;

    public Client(LocalDateTime created, LocalDateTime modified, UserRole role,
                  boolean is_active, String firstName, String last_name, String password, String username,String phoneNumber) {
        super(created, modified);
        this.role = role;
        this.is_active = is_active;
        this.firstName = firstName;
        this.last_name = last_name;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public Client() {
    }

    @Transient
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    @Transient
    @OneToMany(mappedBy = "client")
    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "is_active", nullable = false)
    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "last_name")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
