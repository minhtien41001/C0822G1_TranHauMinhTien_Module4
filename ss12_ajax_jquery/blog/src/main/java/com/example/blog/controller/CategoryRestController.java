package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorys")
@CrossOrigin("*")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        List<Category> categoryList = iCategoryService.findAllList();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> findById(@PathVariable("id") int id){
        Category category = iCategoryService.findById(id);
        if (category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category,HttpStatus.OK);
    }


}
