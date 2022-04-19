package com.company.service;

import com.company.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void delete(int id);

    User getUser(int id);

    void updateUser(int id, User newUser);

    List<User> getAllUsers();
}

