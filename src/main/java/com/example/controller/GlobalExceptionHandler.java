package com.example.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public String handleCustomException(ArithmeticException exception, Model model) {
        model.addAttribute("exception", exception);
        return "/errors/arithmeticError";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "/errors/globalError";
    }
}
