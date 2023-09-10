package com.carservice.web.view.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexViewController {
    @GetMapping
    public String getIndex(Model model) {
        final String welcomeMessage = "Welcome to the car center management system!";
        model.addAttribute("welcome", welcomeMessage);

        final String loginOrRegisterMessage = "Please, login or register to continue.";
        model.addAttribute("loginOrRegister", loginOrRegisterMessage);
        return "index";
    }
}
