package nt.logisticplatform.service;

import nt.logisticplatform.model.User;

public interface UserService {
    User findByUsername(String username);

    User findById(Long id);

    User createUser(User user);

    void deleteUserByPersonId(Long id);
}
