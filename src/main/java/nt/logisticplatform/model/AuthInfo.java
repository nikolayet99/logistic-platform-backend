package nt.logisticplatform.model;

public class AuthInfo {
    private String token;
    private Role role;
    private Long personId;

    public AuthInfo() {
    }

    public AuthInfo(String token, Long personId) {
        this.token = token;
        this.personId = personId;
    }

    public AuthInfo(String token, Role role, Long personId) {
        this.token = token;
        this.role = role;
        this.personId = personId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
