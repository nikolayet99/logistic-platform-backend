package nt.logisticplatform.service.impl;

import nt.logisticplatform.exception.ApiClientRuntimeException;
import nt.logisticplatform.model.*;
import nt.logisticplatform.service.AccessTokenService;
import nt.logisticplatform.service.AuthService;
import nt.logisticplatform.service.PersonService;
import nt.logisticplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserService userService;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    PersonService personService;

    @Override
    public AuthInfo register(RegisterDTO registerDTO) {
        AuthDTO authDTO = registerDTO.getAuthDTO();
        validateAuthDTO(authDTO);
        Person person = registerDTO.getPerson();
        personService.createPerson(person);
        User user = new User(authDTO.getUsername(), authDTO.getPassword(), Role.valueOf(String.valueOf(person.getPersonType())), person);
        userService.createUser(user);
        AccessToken accessToken = accessTokenService.createToken(user.getId());
        return new AuthInfo(accessToken.getToken(), user.getRole(), person.getId());
    }

    @Override
    public AuthInfo login(AuthDTO authDTO) {
        User existingUser = userService.findByUsername(authDTO.getUsername());
        if (existingUser == null || !existingUser.getPassword().equals(authDTO.getPassword()))
            throw new ApiClientRuntimeException("Invalid username or password.");

        AccessToken accessToken = accessTokenService.createToken(existingUser.getId());
        return new AuthInfo(accessToken.getToken(), existingUser.getRole(), existingUser.getPerson().getId());
    }

    private void validateAuthDTO(AuthDTO authDTO) {
        String username = authDTO.getUsername();
        if (username == null || username.length() < 4 || username.length() > 15)
            throw new ApiClientRuntimeException("Invalid username. Must be between 4 and 15 characters long.");

        if (!isValidPassword(authDTO.getPassword()))
            throw new ApiClientRuntimeException(
                    "Invalid password. Must be between 8 and 20 characters long with upper case, lower case and a digit");

        User existingUser = userService.findByUsername(username);
        if (existingUser != null)
            throw new ApiClientRuntimeException("Username is taken.");
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit;
    }
}
