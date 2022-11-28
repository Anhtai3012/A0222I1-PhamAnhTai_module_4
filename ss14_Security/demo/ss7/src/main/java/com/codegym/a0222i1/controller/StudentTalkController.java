package com.codegym.a0222i1.controller;

import com.codegym.a0222i1.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class StudentTalkController {

    @GetMapping("talk/list")
    public String goTalkList(@SessionAttribute("studentTalkList") List<Student> studentList,
                             Model model) {
        model.addAttribute("studentTalkList", studentList);
        return "talkList";
    }

}
