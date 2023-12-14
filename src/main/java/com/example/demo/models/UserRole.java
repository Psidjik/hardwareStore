package com.example.demo.models;

import com.example.demo.models.enums.Role;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{
    private Role role;
    private List<Client> clients;

    public UserRole(Role role) {
        this.role = role;
    }
    public UserRole() {
    }
    @Column(name = "name")
    @Enumerated(value = EnumType.ORDINAL)
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
