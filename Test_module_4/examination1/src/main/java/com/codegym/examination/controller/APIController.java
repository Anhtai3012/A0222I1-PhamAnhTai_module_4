package com.codegym.examination.controller;

import com.codegym.examination.model.QuestionType;
import com.codegym.examination.model.Student;
import com.codegym.examination.service.IQuestionTypeService;
import com.codegym.examination.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("/*")
public class APIController {

    @Autowired
    IStudentService studentService;

    @Autowired
    IQuestionTypeService questionTypeService;

    @ModelAttribute("questionTypes")
    private List<QuestionType> questionTypes(){
        return questionTypeService.findAll();
    }

    @GetMapping("")
    public ModelAndView list(
                             @RequestParam(value = "title",defaultValue = "") String title,
                             @PageableDefault(size = 5, sort = "date", direction = Sort.Direction.DESC) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/list","list",studentService.findAllByName(title,pageable));
        modelAndView.addObject("title",title);
        return  modelAndView;
    }

    @PostMapping("/create")
    public ResponseEntity<Page<Student>>create(@Valid @RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(studentService.findAllByName("",Pageable.unpaged()), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        studentService.removeID(id);
        return  new ResponseEntity<>(studentService.findAllByName("",Pageable.unpaged()),HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Student> edit(@RequestBody Student studentDTO) {
        studentService.save(studentDTO);
        return new ResponseEntity<>(studentDTO, HttpStatus.ACCEPTED);
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
