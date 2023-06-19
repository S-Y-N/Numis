package com.example.numis.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLogin(){return "user/login";}

    @RequestMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "user/login-error";
    }
}

