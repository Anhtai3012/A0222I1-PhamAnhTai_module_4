package com.codegym.e1.controller;

import com.codegym.e1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/")
    public String show(Model model){
        model.addAttribute("user",new User());
        return "/s1";
    }
    @PostMapping("/result")
    public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "s1";
        }
        model.addAttribute("message","successful");
        return "/result";
    }
}
