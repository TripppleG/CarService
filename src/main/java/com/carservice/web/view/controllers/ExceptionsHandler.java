package com.carservice.web.view.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice()
public class ExceptionsHandler {
    @GetMapping("/errors")
    @ExceptionHandler(Exception.class)
    protected String handleException(Exception exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "errors/errors";
    }


}
