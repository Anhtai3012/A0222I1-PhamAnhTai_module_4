package codegym.controller;

import codegym.model.Product;
import codegym.service.IProductService;
import codegym.service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    private IProductService productService = new ProductService();
    @GetMapping("")
    public String product(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "list";
    }
}
