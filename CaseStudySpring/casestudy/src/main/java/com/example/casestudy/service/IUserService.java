package com.example.casestudy.service;

import com.example.casestudy.model.user.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Integer id);
}
