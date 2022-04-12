package com.company.dao;

import com.company.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void delete(int id);

    User get(int id);

    List<User> getAllUsers();

    void set(int id, User newUser);

}
