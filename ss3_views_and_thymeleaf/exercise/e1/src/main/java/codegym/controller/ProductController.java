package codegym.controller;

import codegym.model.Product;
import codegym.service.IProductService;
import codegym.service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private IProductService productService = new ProductService();
    @GetMapping("")
    public String product(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "/list";
    }
    @GetMapping("/form")
    public String showFormCreate(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("link","/create");
       return "/form";
    }
    @PostMapping("/create")
    public String addProduct(Product product,Model model){
        productService.save(product);
        model.addAttribute("mess","successful");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,Model model){
        productService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id,Model model){
        model.addAttribute("link","/edit");
        model.addAttribute("product",productService.findById(id));
        return "/form";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("product") Product product){
        productService.update(product.getId(),product);
        return "redirect:/";
    }
    @PostMapping("/search")
    public String search(Model model, @RequestParam("search") String name){
        List<Product> result = productService.search(name);
        model.addAttribute("productList",result);
        return "/list";
    }
    @GetMapping("/view/{id}")
    public String view(Model model,@PathVariable("id") int id){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }
}
