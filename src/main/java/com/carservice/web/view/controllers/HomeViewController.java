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
    @GetMapping("customers/home")
    public String getCustomerHome(){
        return "customers/home";
    }

    @GetMapping("employee/home")
    public String getEmployeeHome(){
        return "employees/home";
    }
}