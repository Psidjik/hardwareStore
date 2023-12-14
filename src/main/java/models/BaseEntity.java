package models;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {
    String id;

    public BaseEntity(String id) {
        this.id = id;
    }

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
