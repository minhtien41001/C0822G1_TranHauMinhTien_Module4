package com.example.blog.service;

import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    void save(Category category);

    void update(Category category);

    void remove(int id);

    Optional<Category> findById(int id);
}
