package com.example.numis.controllers;

import com.example.numis.domain.models.User;
import com.example.numis.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService _userService;
    @GetMapping("/registration")
    public ModelAndView getRegistration(){
        return new ModelAndView("user/registration","user",new User());
    }

    @PostMapping("/registration")
    public String postRegister(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model){
        /*add error page*/
        if(bindingResult.hasErrors()){
            return "user/registration";
        }
        if(!user.getPassword().equals(user.getPasswordConfirmation())){
            model.addAttribute("passwordError", "Invalid password");
            return "user/registration";
        }
        if(!_userService.registerUser(user)){
            model.addAttribute("usernameForm","Username already exists");
            return "user/registration";
        }
        return "home/index";
    }
}
