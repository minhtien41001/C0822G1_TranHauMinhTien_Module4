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

    @GetMapping("")
    public String showList(@PageableDefault(page = 0,size = 2)
                                   Pageable pageable, Model model) {
        model.addAttribute("blogList", iBlogService.findAll(pageable));
        return "blog/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAllList());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","Add new successful!");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model,Pageable pageable) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAllList());
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAllList());
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("mess","Remove successful!");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAllList());
        return "blog/view";
    }


}
