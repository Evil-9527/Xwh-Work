package com.example.xdemo.service;

import com.example.xdemo.model.User;

import java.util.List;

/**
 * UserService
 */
public interface UserService {

    List<User> getAllUser();

    User getUser(Long id);

    int createUser(User user);

    int deleteUser(Long id);

}
