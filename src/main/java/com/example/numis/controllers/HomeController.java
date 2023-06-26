package com.example.numis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHome(){return "home/index";}
    @GetMapping("/blog")
    public String getBlog(){return "home/blog";}

    @GetMapping("/catalog")
    public String getCatalog(){return "home/catalog";}
    @GetMapping("/collection")
    public String getCollection(){return "home/collection";}
    @GetMapping("/info")
    public String getInfo(){return "home/info";}
    @GetMapping("/profile")
    public String getProfile(){return "home/profile";}
    @GetMapping("/search")
    public String getSearch(){return "home/search";}
    @GetMapping("/policy")
    public String getPolicy(){return "home/policy";}
    @GetMapping("/rules")
    public String getRules(){return "home/rules";}


    @GetMapping("/enter")
    public String getEnter(){return "user/login";}

}
