package com.codegym.jquery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JqueryController {
    @GetMapping("/")
    public String home(){
        return "jquery";
    }
}
