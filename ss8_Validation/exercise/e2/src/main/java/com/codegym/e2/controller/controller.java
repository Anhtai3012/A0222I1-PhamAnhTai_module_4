package com.codegym.e2.controller;

import com.codegym.e2.model.Song;
import com.codegym.e2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class controller {
    @Autowired
    private ISongService songService;

    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("songs",songService.findAll());
        return "/list";
    }

    @GetMapping("/form")
    public String showCreate(Model model){
        model.addAttribute("song", new Song());
        return "/form";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult,Model model){
        new Song().validate(song,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("songs",songService.findAll());
            return "/form";
        }
        songService.save(song);
        return "redirect:/";
    }
}
