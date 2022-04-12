package com.company.service;

import com.company.dao.UserDaoImpl;
import com.company.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDaoImpl;

    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    @Transactional
    public void add(User user) {
        userDaoImpl.add(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDaoImpl.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User get(int id) {
        return userDaoImpl.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        System.out.println("gsagsa");
        return userDaoImpl.getAllUsers();
    }

    @Override
    @Transactional
    public void set(int id, User newUser) {
        userDaoImpl.set(id, newUser);
    }
}

