package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    List<Category> findAllList();

    void save(Category category);

    Category findById(int id);

    void update(Category category);

    void remove(int id);
}
