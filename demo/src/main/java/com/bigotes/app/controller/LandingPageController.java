package com.bigotes.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pag")
public class LandingPageController {

    @GetMapping("/show")
    public String show(){
        return "landing_page";
    }
}
