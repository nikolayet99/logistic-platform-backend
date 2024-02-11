package nt.logisticplatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AccessToken extends AbstractEntity {
    private String token;
    private LocalDateTime validUntil;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public AccessToken() {
    }

    public AccessToken(String token, LocalDateTime validUntil, User user) {
        this.token = token;
        this.validUntil = validUntil;
        this.user = user;
    }

    public AccessToken(Long id, String token, LocalDateTime validUntil, User user) {
        super(id);
        this.token = token;
        this.validUntil = validUntil;
        this.user = user;
    }

    public AccessToken(Long id, LocalDate dateCreated, LocalDate dateUpdated, String token, LocalDateTime validUntil, User user) {
        super(id, dateCreated, dateUpdated);
        this.token = token;
        this.validUntil = validUntil;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
