package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/landing_page")
public class LandingPageController {

    @GetMapping("/show")
    public String show(){
        return "landing_page";
    }
}
