package com.bigotes.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//No se usara
@Controller
@RequestMapping("/pag")
public class LandingPageController {

    // http://localhost:8090/pag/show
    @GetMapping("/show")
    public String show(){
        return "landing_page";
    }
}
