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


}
