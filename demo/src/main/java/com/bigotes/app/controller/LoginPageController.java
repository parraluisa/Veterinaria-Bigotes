package com.bigotes.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigotes.app.model.Owner;
import com.bigotes.app.service.OwnerService;

@Controller
@RequestMapping("/login")
public class LoginPageController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/vetandowner")
    public String showLogin(Model model) {
        Integer idCard = 0;
        model.addAttribute("idCard", idCard);
        return "login_page";
    }

    @PostMapping("/vetandowner")
    public String login(@RequestParam("idCard") Long idCard) {
        Owner owner = ownerService.findByIdCard(idCard);
        if (owner != null) {
            return "redirect:/owner/pets/" + owner.getId();
        } else {
            return "redirect:/owner/login?error=idNotFound";
        }
    }
}
