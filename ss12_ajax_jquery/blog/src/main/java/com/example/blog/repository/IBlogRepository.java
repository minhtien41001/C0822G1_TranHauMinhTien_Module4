package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findById(int id);

    List<Blog> findByTitleContaining(String title);
}
