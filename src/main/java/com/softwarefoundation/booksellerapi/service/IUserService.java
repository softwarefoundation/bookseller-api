package com.softwarefoundation.booksellerapi.service;

import com.softwarefoundation.booksellerapi.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}
