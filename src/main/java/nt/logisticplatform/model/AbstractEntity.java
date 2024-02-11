package nt.logisticplatform.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDate dateCreated;

    @Column(name = "date_updated", nullable = false)
    private LocalDate dateUpdated;

    protected AbstractEntity() {
    }

    protected AbstractEntity(Long id) {
        this.id = id;
    }

    protected AbstractEntity(Long id, LocalDate dateCreated, LocalDate dateUpdated) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    @PrePersist
    protected void onCreate() {
        setDateCreated(LocalDate.now());
        setDateUpdated(LocalDate.now());
    }

    @PreUpdate
    protected void onUpdate() {
        setDateUpdated(LocalDate.now());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
