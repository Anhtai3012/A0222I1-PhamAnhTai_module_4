package com.codegym.product.controller;

import com.codegym.product.model.Category;
import com.codegym.product.model.Product;
import com.codegym.product.service.ICategoryService;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("cate")
    public List<Category> product(){
        return categoryService.findAll();
    }

//    @GetMapping({"/","/product"})
//    public String showList(Model model){
//        model.addAttribute("products",productService.findAll());
//        return "product/list";
//    }
//@GetMapping(value = "/list")
//public String showList(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
//    Sort sort = Sort.by("point").descending().and(Sort.by("nameStudent").descending());
//    model.addAttribute("listStudent", iStudentService.getAll(PageRequest.of(page,1, sort)));
//    return "list";
//}
    @GetMapping(value = {"/","/product"})
    public String showlist(Model model,@RequestParam(value = "page", defaultValue = "0") int page){
        model.addAttribute("products",productService.getAll(PageRequest.of(page,3)));
        return "product/list";
    }

    @GetMapping("/form")
    public String showCreate(Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("product", new Product());
        model.addAttribute("link","/product/create");
      //  model.addAttribute("category",categoryService.findAll());
        return "product/form";
    }
    @PostMapping(value = "/product/create")
    public String create(RedirectAttributes redirectAttributes,Model model,@ModelAttribute("product") Product product){
        redirectAttributes.addFlashAttribute("message","successful");
       productService.save(product);
        return "redirect:/";
    }
    @GetMapping(value = "delete-product/{id}")
    public String delete(@PathVariable("id") Integer id){
        productService.delete(id);
        return "redirect:/";
    }
    @GetMapping(value = "edit-product/{id}")
    public String showEdit(Model model,@PathVariable("id") Integer id){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        model.addAttribute("link","/product/edit");
        return "product/form";
    }
    @PostMapping(value = "/product/edit")
    public  String edit(RedirectAttributes redirectAttributes,@ModelAttribute("product") Product product){
        redirectAttributes.addFlashAttribute("message","successful");
        productService.save(product);
        return "redirect:/";
    }
}
