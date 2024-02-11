package nt.logisticplatform.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Person extends AbstractEntity {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    public Person() {
    }

    public Person(Long id) {
        super(id);
    }

    public Person(String name, String email, String address, String phoneNumber, PersonType personType) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.personType = personType;
    }

    public Person(Long id, String name, String email, String address, String phoneNumber, PersonType personType) {
        super(id);
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.personType = personType;
    }

    public Person(Long id, LocalDate dateCreated, LocalDate dateUpdated, String name, String email, String address,
                  String phoneNumber, PersonType personType) {
        super(id, dateCreated, dateUpdated);
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.personType = personType;
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

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }
}
