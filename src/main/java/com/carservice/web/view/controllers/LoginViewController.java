package com.carservice.web.view.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class LoginViewController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/home")
    public String loginHome(){
        return "customers/home";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }
}