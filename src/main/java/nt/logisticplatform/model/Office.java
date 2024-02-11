package nt.logisticplatform.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Office extends AbstractEntity {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public Office() {
    }

    public Office(Long id) {
        super(id);
    }

    public Office(String name, String email, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Office(Long id, String name, String email, String address, String phoneNumber) {
        super(id);
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Office(Long id, LocalDate dateCreated, LocalDate dateUpdated, String name, String email, String address, String phoneNumber) {
        super(id, dateCreated, dateUpdated);
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
