package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(page = 0,size = 3) Pageable pageable){
        Page<Category> categories = iCategoryService.findAll(pageable);
        model.addAttribute("categoriesList",categories);
        return "category/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/save")
    public String save(Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","Add new successful!");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category,RedirectAttributes redirectAttributes){
        iCategoryService.update(category);
        redirectAttributes.addFlashAttribute("mess","Update successful!");
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "category/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Category category,RedirectAttributes redirectAttributes){
        iCategoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("mess","Remove successful!");
        return "redirect:/category";
    }
}
