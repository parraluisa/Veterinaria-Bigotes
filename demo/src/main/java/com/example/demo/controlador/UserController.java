package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entidad.User;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private User user;

    /*Este ejemplo va primero ya que todavia no se introduce thymeleaf */
    @RequestMapping("/info")
    @ResponseBody
    public String mostrarInfoUsuario(){
        String html = "";
        html += "<h1>User info</h1>";
        html += "<h1>Nombre: " + user.getName() + "</h1>";
        html += "<h1>Correo: " + user.getCorreo() + "</h1>";
        html += "<h1>Edad: " + user.getEdad() + "</h1>";
        return html;
    }

    /*Primer ejemplo introduciendo thymeleaf */
    @RequestMapping("/info2")
    public String mostrarInfoUsuario2(Model model){
        model.addAttribute("usuario", user);
        return "datos_usuario";
    }
}
