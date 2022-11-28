package com.codegym.test.controller;

import com.codegym.test.model.Category;
import com.codegym.test.model.Product;
import com.codegym.test.service.ICategoryService;
import com.codegym.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductAPIController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    private List<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("")
    public ModelAndView list(@RequestParam(value = "name", defaultValue = "") String name,
                             @RequestParam(value = "title",defaultValue = "") String title,
                             @PageableDefault(size = 5, sort = "reporter", direction = Sort.Direction.ASC) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",name);
        modelAndView.addObject("title",title);
//        return new ModelAndView("product/list","list",productService.findAllByName(name,pageable));
        return  new ModelAndView("product/list","list",productService.findAllTwoField(name,title,pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<Page<Product>> create(@Valid @RequestBody Product productDTO) {
        productService.save(productDTO);
        return new ResponseEntity<>(productService.findAllTwoField("","",Pageable.unpaged()),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        productService.removeID(id);
        return  new ResponseEntity<>(productService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Product> edit(@RequestBody Product productDTO) {
        productService.save(productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.ACCEPTED);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> notFoundHandle(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
