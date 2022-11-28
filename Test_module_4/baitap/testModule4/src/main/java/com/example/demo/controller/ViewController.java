package com.example.demo.controller;

import com.example.demo.model.StatusQuestion;
import com.example.demo.model.TypeQuestion;
import com.example.demo.service.IDependentQuestionService;
import com.example.demo.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {
    private final int MAX_DISPLAY = 5;

    @Autowired
    IQuestionService questionService;

    @Autowired
    IDependentQuestionService<TypeQuestion> typeService;

    @Autowired
    IDependentQuestionService<StatusQuestion> statusService;

    @ModelAttribute("listType")
    private List<TypeQuestion> getTypeList() {
        return typeService.findAll();
    }

    @ModelAttribute("listStatus")
    private List<StatusQuestion> getStatusList() {
        return statusService.findAll();
    }

    @GetMapping("")
    public String goHome(Model model,
                         @RequestParam(defaultValue = "") String title,
                         @RequestParam(defaultValue = "") String type,
                         @PageableDefault(size = MAX_DISPLAY) Pageable pageable) {
        model.addAttribute("list", questionService.findAllByTitleAndType(title, type, pageable));
        model.addAttribute("title", title);
        model.addAttribute("type", type);
        return "home";
    }
}