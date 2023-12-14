package models;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class BaseEntityWithCreatModif extends BaseEntity{
    private LocalDateTime created;
    private LocalDateTime modified;

    public BaseEntityWithCreatModif(LocalDateTime created, LocalDateTime modified) {
        this.created = created;
        this.modified = modified;
    }

    public BaseEntityWithCreatModif() {
    }
    @Column(name = "created")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    @Column(name = "modified")
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

}
