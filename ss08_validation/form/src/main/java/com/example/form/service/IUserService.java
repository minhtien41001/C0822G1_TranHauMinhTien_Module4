package com.example.form.service;

import com.example.form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    Page<User> findAll(Pageable pageable);

    void save(User user);


}
