package com.carservice.web.view.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class HomeViewController {
    @GetMapping("/home")
    public String getHome(){
        return "customers/home";
    }
}
