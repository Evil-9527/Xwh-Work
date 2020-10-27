package com.example.xdemo.service.Impl;

import com.example.xdemo.mapper.UserMapper;
import com.example.xdemo.model.User;
import com.example.xdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userMapper.findOne(id);
    }

    @Override
    public int createUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.delete(id);
    }
}
