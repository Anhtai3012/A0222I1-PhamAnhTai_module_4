package com.example.demo.controller;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.model.Question;
import com.example.demo.model.StatusQuestion;
import com.example.demo.model.TypeQuestion;
import com.example.demo.service.IDependentQuestionService;
import com.example.demo.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("/*")
@RequestMapping("/api")
public class ApiController {
    @Autowired
    IQuestionService questionService;

    @Autowired
    IDependentQuestionService<TypeQuestion> typeService;

    @Autowired
    IDependentQuestionService<StatusQuestion> statusService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable Long id) {
//        questionService.removeById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
        Optional<Question> questionServiceById = questionService.findById(id);
        return questionServiceById.map(x -> {
            questionService.removeById(id);
            return new ResponseEntity<>(x, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("{id}")
    public ResponseEntity<Question> findById(@PathVariable Long id) throws Exception {
        Optional<Question> categoryOptional = questionService.findById(id);
        return categoryOptional.map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElseThrow(Exception::new);
//        return new ResponseEntity<>(questionService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Question> saveQuestion(@Valid @RequestBody QuestionDTO questionDTO) {
        return new ResponseEntity<>(questionService.save(new Question(questionDTO)), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Question> editQuestion(@Valid @RequestBody QuestionDTO dto) {
        Question question = questionService.editQuestion(dto);
        return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);
    }
}
