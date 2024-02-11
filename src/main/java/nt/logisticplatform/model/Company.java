package nt.logisticplatform.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Company extends AbstractEntity {
    private String name;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(Long id, String name) {
        super(id);
        this.name = name;
    }

    public Company(Long id, LocalDate dateCreated, LocalDate dateUpdated, String name) {
        super(id, dateCreated, dateUpdated);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
