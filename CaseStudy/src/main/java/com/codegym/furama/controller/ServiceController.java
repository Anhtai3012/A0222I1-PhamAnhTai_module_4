package com.codegym.furama.controller;

import com.codegym.furama.model.service.MainService;
import com.codegym.furama.model.service.RentType;
import com.codegym.furama.model.service.ServiceType;
import com.codegym.furama.service.service_spring.IMainService;
import com.codegym.furama.service.service_spring.IRentTypeService;
import com.codegym.furama.service.service_spring.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

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
    public String list(Model model, @RequestParam(value = "name", defaultValue = "") String name,
                       @PageableDefault(size = 3, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("list", mainService.findAllByName(name, pageable));
        model.addAttribute("name_search", name);
        return "service/list";
    }

    @GetMapping("/create")
    public String createService(Model model) {
        model.addAttribute("service", new MainService());
        return "service/form";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("service") MainService service, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "successful");
        mainService.save(service);
        return "redirect:/service";
    }

    @GetMapping("/delete")
    public String delete(@Param("id") Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "successful");
        mainService.remove(id);
        return "redirect:/service";
    }


//    @GetMapping("findOne/{id}")
//    public MainService findOne(@RequestBody @PathVariable("id") Integer id) {
//        return mainService.findById(id).get();
//    }

    @PutMapping("/api/edit")
    public ResponseEntity<MainService> edit(@RequestBody MainService serviceDTO) {
        mainService.save(serviceDTO);
        return new ResponseEntity<>(serviceDTO, HttpStatus.ACCEPTED);
    }

    @ResponseBody
    @PostMapping("/api/create")
    public ResponseEntity<?> create( @RequestBody MainService serviceDTO) {
        mainService.save(serviceDTO);
        return new ResponseEntity<>(mainService.findAllByName("",Pageable.unpaged()),HttpStatus.CREATED);
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
