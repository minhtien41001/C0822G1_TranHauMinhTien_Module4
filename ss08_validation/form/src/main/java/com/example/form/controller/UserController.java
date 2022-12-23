package com.example.form.controller;

import com.example.form.dto.UserDto;
import com.example.form.model.User;
import com.example.form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("listUser",iUserService.findAll(pageable));
        return "user/list";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("userDto",new UserDto());
        return "user/create";
    }

    @PostMapping("/save")
    public String saveUser(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "user/create";
        }
        else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            iUserService.save(user);
            return "redirect:/users";
        }
    }
}
