package com.example.numis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoinController {

    @GetMapping("/coins")
    public String getCoins(){return "collection/coin";}

}
