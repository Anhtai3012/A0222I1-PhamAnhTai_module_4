package com.codgym.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Tranfers {
    @GetMapping("/")
    public String writing(){
        return "writing/list";
    }
}
