package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5)Pageable pageable, Model model){
        model.addAttribute("categoryList",iCategoryService.findAll(pageable));
        return "category/list";
    }

    @GetMapping("/create")
    public String createCategory(Model model,Pageable pageable){
        model.addAttribute("categoryList",iCategoryService.findAll(pageable));
        model.addAttribute("category",new Category());
        return "category/create";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category")Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","Add new successful!");
        return "redirect:/category/list";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable int id,Model model,Pageable pageable){
        model.addAttribute("category",iCategoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category,RedirectAttributes redirectAttributes){
        iCategoryService.update(category);
        redirectAttributes.addFlashAttribute("mess","Update successful!");
        return "redirect:/category/list";
    }

    @GetMapping("/delete")
    public String deleteCategory(@RequestParam(value = "idDelete") Integer id){
        iCategoryService.remove(id);
        return "redirect:/category/list";
    }
}
