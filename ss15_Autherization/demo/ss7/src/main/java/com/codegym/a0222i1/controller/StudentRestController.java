package com.codegym.a0222i1.controller;

import com.codegym.a0222i1.model.Student;
import com.codegym.a0222i1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
@CrossOrigin("http://localhost:63342/")
public class StudentRestController {

    @Autowired
    @Qualifier("studentService")
    private IStudentService iStudentService;

    @GetMapping(value = "/list")
    public Page<Student> showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("point").descending().and(Sort.by("nameStudent").descending());
        return iStudentService.getAll(PageRequest.of(page, 1, sort));
    }

    @ResponseBody
    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student) {
        iStudentService.save(student);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
