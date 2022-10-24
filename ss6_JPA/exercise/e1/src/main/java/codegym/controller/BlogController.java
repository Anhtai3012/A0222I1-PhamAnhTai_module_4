package codegym.controller;

import codegym.model.Blog;
import codegym.model.BlogDAO;
import codegym.model.Category;
import codegym.service.BlogService;
import codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("blogs",blogService.findAll());
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("link","/create");
        return "/form";
    }
    @PostMapping("/create")
    public String create(RedirectAttributes redirectAttributes,@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes,@PathVariable("id") int id){
        blogService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") int id,Model model){
       Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        model.addAttribute("link","/edit");
        return "/form";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog,RedirectAttributes redirectAttributes){
        blogService.save(blog);
        return "redirect:/";
    }
}
