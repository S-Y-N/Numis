package com.example.numis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    @GetMapping("/catalog")
    public String getCatalog(){return "catal/catalog";}
    @GetMapping("/catalog/coins-rsfsr")
    public String getCoinsRsfsr(){return "catal/coins-rsfsr";}
    @GetMapping("/catalog/coins-first")
    public String getCoinFirst(){return "catal/coins-first";}
    @GetMapping("/catalog/coins-second")
    public String getCoinSecond(){return "catal/coins-second";}
    @GetMapping("/catalog/coins-third")
    public String getCoinThird(){return "catal/coins-third";}
}
