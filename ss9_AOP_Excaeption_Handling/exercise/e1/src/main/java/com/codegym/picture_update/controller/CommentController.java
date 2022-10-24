package com.codegym.picture_update.controller;

import com.codegym.picture_update.model.Comment;
import com.codegym.picture_update.model.Picture;
import com.codegym.picture_update.repository.CommentRepository;
import com.codegym.picture_update.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PictureRepository pictureRepository;

    @GetMapping("home")
    public String home(Model model, @RequestParam(required = false) Integer c) {
        if(c != null){
            commentRepository.update(c);
        }

        model.addAttribute("comment", new Comment());
        ZonedDateTime tz = ZonedDateTime.now(ZoneId.of("America/New_York"));
        Optional<Picture> optionalPicture = pictureRepository.find(tz.toLocalDate());
        model.addAttribute("picture", optionalPicture.isPresent() ? optionalPicture.get() : new Picture());

        return "home";
    }

    @PostMapping("save")
    public String save(Comment comment) {
        commentRepository.save(comment);
        return "redirect:/home";
    }
}
