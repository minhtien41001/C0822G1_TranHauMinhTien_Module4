package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
    Page<Blog> searchByTitle( String title ,Pageable pageable);

    void save(Blog blog);

    void update(Blog blog);

    void remove(int id);

    Optional<Blog> findById(int id);
}
