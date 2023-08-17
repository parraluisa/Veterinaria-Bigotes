package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping
@RequestMapping("/mundo")
public class HolaMundoController {
    /* 
    @GetMapping
    @ResponseBody
    public String holaMundo(){
        return "<h1>Hola mundo</h1>";
    }*/

    /*
    @GetMapping("/hola")
    @ResponseBody
    public String holaMundo(){
        return "<h1>Hola mundo</h1>";
    }

    @GetMapping("/chao")
    @ResponseBody
    public String chaoMundo(){
        return "<h1>chao mundo</h1>";
    }*/

    //quitar response body
    @GetMapping("/hola")
    public String holaMundo(){
        return "hola_mundo";
    }

    @GetMapping("/chao")
    public String chaoMundo(){
        return "chao_mundo";
    }

}
