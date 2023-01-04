package com.example.exercise_lvn.repository;

import com.example.exercise_lvn.model.AppUser;
import com.example.exercise_lvn.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
