package com.example.jpacrud.controller;

import com.example.jpacrud.model.User;
import com.example.jpacrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/adduser")
    public String shoeAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "addUserPage";
    }

    @PostMapping("/registerprocess")
    public String registerProcess(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
userService.saveUser(user);
return "/";

    }


}
