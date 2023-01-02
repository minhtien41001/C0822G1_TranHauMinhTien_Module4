package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<Page<Blog>> findAllBlog(@PageableDefault(value = 0, size = 5,sort = {"author"})Pageable pageable){
        Page<Blog> blogList = iBlogService.findAll(pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> findById(@PathVariable ("id") int id){
        Blog blog = iBlogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Blog> create(@RequestBody Blog blog){
        iBlogService.save(blog);
        Blog blog1 = iBlogService.findById(blog.getId());
        return new ResponseEntity<>(blog1,HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Blog> delete(@PathVariable ("id") int id){
        Blog blog = iBlogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
