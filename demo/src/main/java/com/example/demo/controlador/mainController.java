package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class mainController {

    @RequestMapping("/show")
    public String show(){
        return "landing_page";
    }
}
