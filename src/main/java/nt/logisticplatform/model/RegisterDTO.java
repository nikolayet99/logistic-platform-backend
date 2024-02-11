package nt.logisticplatform.model;

public class RegisterDTO {
    private AuthDTO authDTO;
    private Person person;

    public RegisterDTO() {
    }

    public RegisterDTO(AuthDTO authDTO, Person person) {
        this.authDTO = authDTO;
        this.person = person;
    }

    public AuthDTO getAuthDTO() {
        return authDTO;
    }

    public void setAuthDTO(AuthDTO authDTO) {
        this.authDTO = authDTO;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

