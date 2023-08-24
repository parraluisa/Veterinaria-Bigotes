package com.bigotes.app.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bigotes.app.exception.NotFoundException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(NotFoundException.class)
    public String ItemNotFoundExceptionHandler(Model model, NotFoundException exception){
        return "error_404";
    }
    
}
