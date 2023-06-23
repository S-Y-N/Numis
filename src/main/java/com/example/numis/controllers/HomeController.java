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
    @GetMapping("/mycollection")
    public String getCollection(){return "home/collection";}
    @GetMapping("/info")
    public String getInfo(){return "home/info";}
    @GetMapping("/profile")
    public String getProfile(){return "home/profile";}
    @GetMapping("/search")
    public String getSearch(){return "home/search";}

    @GetMapping("/enter")
    public String getEnter(){return "user/login";}

}
