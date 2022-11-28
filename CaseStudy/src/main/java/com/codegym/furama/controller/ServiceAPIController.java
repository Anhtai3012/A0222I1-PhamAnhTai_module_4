package com.codegym.furama.controller;

import com.codegym.furama.model.service.MainService;
import com.codegym.furama.model.service.RentType;
import com.codegym.furama.model.service.ServiceType;
import com.codegym.furama.service.service_spring.IMainService;
import com.codegym.furama.service.service_spring.IRentTypeService;
import com.codegym.furama.service.service_spring.IServiceType;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/service")
public class ServiceAPIController {

    @Autowired
    private IMainService mainService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceType serviceType;

    @ModelAttribute("rentTypes")
    public List<RentType> rentTypes() {
        return rentTypeService.findAll();
    }

    @ModelAttribute("serviceTypes")
    public List<ServiceType> serviceTypes() {
        return serviceType.findAll();
    }

    @GetMapping("")
    public ModelAndView list(Model model, @RequestParam(value = "name", defaultValue = "") String name,
                             @PageableDefault(size = 3, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name_search",name);
        return new ModelAndView("service/list","list",mainService.findAllByName(name, pageable));
    }

    @PutMapping("/edit")
    public ResponseEntity<MainService> edit(@RequestBody MainService serviceDTO) {
        mainService.save(serviceDTO);
        return new ResponseEntity<>(serviceDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody MainService serviceDTO) {
        mainService.save(serviceDTO);
        return new ResponseEntity<>(mainService.findAllByName("",Pageable.unpaged()),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        mainService.remove(id);
        return  new ResponseEntity<>(mainService.findAllByName("",Pageable.unpaged()),HttpStatus.OK);
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
