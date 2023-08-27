package com.bigotes.app.controller;

import com.bigotes.app.exception.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(NotFoundException.class)
    public String ItemNotFoundExceptionHandler(){
        return "error_404";
    }
    
}
