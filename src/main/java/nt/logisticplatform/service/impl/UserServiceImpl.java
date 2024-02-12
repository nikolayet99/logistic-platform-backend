package nt.logisticplatform.service.impl;

import nt.logisticplatform.exception.ApiClientRuntimeException;
import nt.logisticplatform.model.User;
import nt.logisticplatform.repository.UserRepository;
import nt.logisticplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty())
            throw new ApiClientRuntimeException("Invalid user id provided.");

        return userOptional.get();
    }

    @Override
    public User createUser(User user) {
        validateUser(user);
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUserByPersonId(Long id) {
        userRepository.deleteByPersonId(id);
    }

    private void validateUser(User user) {
        if (user.getRole() == null)
            throw new ApiClientRuntimeException("Invalid user role provided.");

        String username = user.getUsername();
        if (username == null || username.length() < 4 || username.length() > 15)
            throw new ApiClientRuntimeException("Invalid username. Must be between 4 and 15 characters long.");

        if (!isValidPassword(user.getPassword()))
            throw new ApiClientRuntimeException(
                    "Invalid password. Must be between 8 and 20 characters long with upper case, lower case and a digit");

        User existingUser = findByUsername(username);
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
