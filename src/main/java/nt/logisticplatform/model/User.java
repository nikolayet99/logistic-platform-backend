package nt.logisticplatform.model;

import jakarta.persistence.*;

@Entity
public class User extends AbstractEntity {
    private String username;
    private String password;
    private Role role;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public User() {
    }

    public User(Long id) {
        super(id);
    }

    public User(String username, String password, Role role, Person person) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRoles(Role role) {
        this.role = role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
