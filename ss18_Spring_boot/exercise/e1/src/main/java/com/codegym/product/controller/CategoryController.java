package com.codegym.product.controller;

import com.codegym.product.model.Category;
import com.codegym.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    

    @GetMapping(value = "/view-category")
    public String showListCategory(Model model){
        model.addAttribute("categorys",categoryService.findAll());
        return "category/list";
    }
    @GetMapping(value = "/form-category")
    public String showCreate(Model model){
        model.addAttribute("category",new Category());
        model.addAttribute("link","/category/create");
        return "category/form";
    }
    @PostMapping(value = "/category/create")
    public String create(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","successful");
        categoryService.save(category);
        return "redirect:/view-category";
    }
    @GetMapping(value = "/delete-category/{id}")
    public String delete(@ModelAttribute("category") Category category, @PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        Category category1 = categoryService.findById(id);
        categoryService.delete(category1);
        redirectAttributes.addFlashAttribute("message","successful");
        return "redirect:/view-category";
    }
    @GetMapping(value = "/edit-category/{id}")
    public String showEdit(Model model,@PathVariable("id") Integer id){
        model.addAttribute("category",categoryService.findById(id));
        model.addAttribute("link","/category/edit");
        return "category/form";
    }
    @PostMapping(value = "/category/edit")
    public String edit(@ModelAttribute("category") Category category,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","successful");
        categoryService.save(category);
        return "redirect:/view-category";
    }
}
