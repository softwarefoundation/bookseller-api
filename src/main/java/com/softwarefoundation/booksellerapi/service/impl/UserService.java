package com.softwarefoundation.booksellerapi.service.impl;

import com.softwarefoundation.booksellerapi.model.Role;
import com.softwarefoundation.booksellerapi.model.User;
import com.softwarefoundation.booksellerapi.repository.IUserReposotory;
import com.softwarefoundation.booksellerapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserReposotory userReposotory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());
        return userReposotory.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userReposotory.findByUsername(username);
    }

    @Override
    @Transactional
    public void makeAdmin(String username) {
        userReposotory.updateUserRole(username, Role.ADMIN);
    }

}
