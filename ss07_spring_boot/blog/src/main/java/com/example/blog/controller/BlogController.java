package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5)Pageable pageable,
                           @RequestParam(value = "title",defaultValue = "")String title,
                           Model model){
        model.addAttribute("blogList",iBlogService.searchByTitle(title, pageable));
        model.addAttribute("categoryList",iCategoryService.findAll(pageable));
        model.addAttribute("title",title);
        return "blog/list";
    }

    @GetMapping("/create")
    public String createBlog(Model model,Pageable pageable){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList",iCategoryService.findAll(pageable));
        return "blog/create";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/blog/list";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable int id,Model model,Pageable pageable){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("categoryList",iCategoryService.findAll(pageable));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("mess","Update successful!");
        return "redirect:/blog/list";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam(value = "idDelete") Integer id){
        iBlogService.remove(id);
        return "redirect:/blog/list";
    }

    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable int id,Model model,Pageable pageable){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("categoryList",iCategoryService.findAll(pageable));
        return"blog/view";
    }
}
