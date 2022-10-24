package com.codegym.product.controller;

import com.codegym.product.model.Product;
import com.codegym.product.service.ICategoryService;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    IProductService service;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String goHome(Model model, @RequestParam(value = "name", defaultValue = "") String name,
                         @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("list", service.findAllByName(name, pageable));
        return "home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("list", categoryService.findAll());
        return "/update";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        assert service.findById(id).isPresent();
        model.addAttribute("product", service.findById(id).get());
        model.addAttribute("list", categoryService.findAll());
        return "/update";
    }

    @PostMapping("/update")
    public String updateDB(@Valid @ModelAttribute("product") Product product, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", categoryService.findAll());
            return "/update";
        }
        service.save(product);
        if (product.getId() == null) {
            redirectAttributes.addFlashAttribute("message", "create ok");
        } else {
            redirectAttributes.addFlashAttribute("message", "edit ok");
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id,RedirectAttributes redirectAttributes){
        service.removeById(id);
        redirectAttributes.addFlashAttribute("message","delete ok");
        return "redirect:/";
    }
}
