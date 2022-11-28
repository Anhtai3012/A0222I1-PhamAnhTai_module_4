package com.codgym.demo.controller;

import com.codgym.demo.model.Category;
import com.codgym.demo.model.Writing;
import com.codgym.demo.service.CategoryService;
import com.codgym.demo.service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/writing")
public class WrittingController {

    @Autowired
    private WritingService writingService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAllNoSort();
    }

    //GetMapping(value = {"/list","/"})
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Writing>> list(){
        Iterable<Writing> writings = writingService.findAllNoSort();
        if (writings==null){
            return new ResponseEntity<Iterable<Writing>>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<Iterable<Writing>>(writings, HttpStatus.OK);
        }
    }


//    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    public ResponseEntity<Void> create(@RequestBody JsonObject writingJson, UriComponentsBuilder uriComponentsBuilder){
//        //JsonObject writingJson = (JsonObject) Json;
//        Writing writing = new Writing();
//        writing.setContent((String) writingJson.get("content"));
//        writing.setTittle((String) writingJson.get("tittle"));
//        writing.setTime(new Date());
//        Category category = categoryService.findById(Long.parseLong((String) writingJson.get("category")));
//        writing.setCategory(category);
//        writingService.save(writing);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(uriComponentsBuilder.path("/writing/{id}").buildAndExpand(writing.getId()).toUri());
//        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
//    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> create(@RequestBody Writing writing, UriComponentsBuilder uriComponentsBuilder){
        writing.setTime (Date.valueOf(LocalDate.now()));
        //Category category = categoryService.findById(Long.parseLong((String) writingJson.get("category")));
//        writing.setCategory(category);
        writingService.save(writing);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/writing/{id}").buildAndExpand(writing.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Writing> edit(@PathVariable("id") Long id, @RequestBody Writing writing){
        Writing currentWriting = writingService.findById(id);
        if ((writing==null) || (currentWriting==null)){
            return new ResponseEntity<Writing>(HttpStatus.NOT_FOUND);
        }
        //Category category = categoryService.findById(Long.parseLong((String) writingJson.get("category")));
        currentWriting.setCategory(writing.getCategory());
        currentWriting.setTittle(writing.getTittle());
        currentWriting.setContent(writing.getContent());
        writingService.save(currentWriting);
        return new ResponseEntity<Writing>(currentWriting, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Writing> view(@PathVariable("id") Writing writing){
        if (writing==null){
            return new ResponseEntity<Writing>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Writing>(writing, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Writing> remove(@PathVariable("id") Writing writing){
        if (writing==null){
            return new ResponseEntity<Writing>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Writing>(HttpStatus.NO_CONTENT);
        }
    }
}