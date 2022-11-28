package com.codegym.furama.controller;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.service.customer.ICustomerService;
import com.codegym.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypeList(){
        return customerTypeService.findAll();
    }

    @GetMapping("")
    public String listCustomer(Model model,@RequestParam(value = "name", defaultValue = "") String name,
                         @PageableDefault(size = 3, sort = "name", direction = Sort.Direction.ASC) Pageable pageable){
//        model.addAttribute("listCustomer",customerService.findAll());
        model.addAttribute("listCustomer",customerService.findAllByName(name,pageable));
        model.addAttribute("name_search",name);
       return "/customer/list";
    }

    @GetMapping("/create")
    public String createCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }

    @PostMapping("/save")
    public String Save(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","successful");
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id,RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","successful");
        return "redirect:/customer";
    }
}
