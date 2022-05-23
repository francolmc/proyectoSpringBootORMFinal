package com.proyectospormfinal.proyectospormfinal.controller;

import java.util.List;

import com.proyectospormfinal.proyectospormfinal.model.User;
import com.proyectospormfinal.proyectospormfinal.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService _userService;
    
    public UserController(UserService userService) {
        this._userService = userService;
    }

    @GetMapping("/user")
    public String getUsers(Model model) {
        List<User> users = this._userService.getUsers();
        model.addAttribute("users", users);
        return "user/user-list.html";
    }
}
