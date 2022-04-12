package com.company.service;

import com.company.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void delete(int id);

    User get(int id);

    void set(int id, User newUser);

    List<User> getAllUsers();
}

