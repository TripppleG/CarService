package com.carservice.web.view.controllers;

import com.carservice.data.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class LoginViewController {
    @GetMapping("/login")
    public String getLogin(/*Model model, Authentication authentication*/) {
//        Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("username", authentication.getName());
//
//        User principal = (User) authentication.getPrincipal();
//        model.addAttribute("username", principal.getAuthorities());
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

    @GetMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }
}