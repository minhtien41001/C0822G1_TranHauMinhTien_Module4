package com.example.casestudy.repository.security;

import com.example.casestudy.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String name);
}
