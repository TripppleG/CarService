package com.carservice.web.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterViewController {
    @GetMapping()
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping()
    public String registerUser(/* TODO Add logic */) {
        return "redirect:/login";
    }



}
