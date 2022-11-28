package com.codegym.examination.controller;

import com.codegym.examination.dto.CustomerDTO;
import com.codegym.examination.model.Customer;
import com.codegym.examination.model.Serve;
import com.codegym.examination.service.ICustomerService;
import com.codegym.examination.service.IServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("/*")
@Controller
public class APIController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServeService serveService;

    @ModelAttribute("customers")
    private List<Customer> customers() {
        return customerService.findAll();
    }
//
//    @GetMapping("")
//    public ModelAndView list(
//            @RequestParam(value = "name", defaultValue = "") String name,
//            @PageableDefault(size = 5, sort = "service_type", direction = Sort.Direction.ASC) Pageable pageable
//    ) {
//        ;
//        ModelAndView modelAndView = new ModelAndView("/list", "list", serveService.findAllByName(name, pageable));
//        modelAndView.addObject("name", name);
//        return modelAndView;
//    }

    @GetMapping("/list")
    public ResponseEntity<Page<Serve>> goList(@RequestParam(value = "name", defaultValue = "") String name,
                                              @PageableDefault(size = 5, sort = "service_type", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(serveService.findAllByName(name, pageable), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<Page<Serve>> create(@Valid @RequestBody Serve serve) {
        serveService.save(serve);
        return new ResponseEntity<>(serveService.findAllByName("", Pageable.unpaged()), HttpStatus.CREATED);
    }
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createDTO(@Valid @RequestBody CustomerDTO dto) {
//        customerService.save(new Customer(dto));
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        serveService.removeID(id);
        return new ResponseEntity<>(serveService.findAllByName("", Pageable.unpaged()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ModelAndView view(Model model, @PathVariable("id") Integer id) {
        Optional<Serve> serve = serveService.findById(id);
        return new ModelAndView("view", "serve", serve.get());
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
