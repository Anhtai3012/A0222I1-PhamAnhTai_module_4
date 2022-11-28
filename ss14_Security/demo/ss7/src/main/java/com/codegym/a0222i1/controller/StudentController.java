package com.codegym.a0222i1.controller;

import com.codegym.a0222i1.model.Student;
import com.codegym.a0222i1.service.IClassroomService;
import com.codegym.a0222i1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Controller
@SessionAttributes("studentTalkList")
public class StudentController {

    @Autowired
    @Qualifier("studentService")
    private IStudentService iStudentService;

    @Autowired
    private IClassroomService iClassroomService;

    @ModelAttribute("studentTalkList")
    public List<Student> createStudentTalkList() {
        return new ArrayList<>();
    }

    @GetMapping("/addTalk/{id}")
    public String addToTalkList(@PathVariable("id")Integer id,
                                @ModelAttribute("studentTalkList")List<Student> studentTalkList,
                                RedirectAttributes redirectAttributes) {
        Student student = iStudentService.getStudentById(id);
        studentTalkList.add(student);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới vào talk thành công");
        return "redirect:/list";
    }
    //    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @GetMapping(value = "/list")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("point").descending().and(Sort.by("nameStudent").descending());
        model.addAttribute("listStudent", iStudentService.getAll(PageRequest.of(page, 1, sort)));
        return "list";
    }

    @GetMapping(value = "detail/{id}")
    public String showDetail(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("student", iStudentService.getStudentById(id));
        return "detail";
    }

    @GetMapping(value = "detail")
    public String showDetailByRequestParam(@RequestParam(defaultValue = "2") int id, Model model) {
        model.addAttribute("student", iStudentService.getStudentById(id));
        return "detail";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listClass", iClassroomService.findAll());
        model.addAttribute("listGender", new String[]{"1", "0"});
        return "/create";

    }

    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
                                Model model,
                                @CookieValue(value = "cookieCount", defaultValue = "0") String countStudent,
                                RedirectAttributes redirectAttributes,
                                HttpServletResponse response) {

        new Student().validate(student, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("listClass", iClassroomService.findAll());
            return "/create";
        }
        iStudentService.save(student);
        Cookie cookie = new Cookie("cookieCount", Integer.parseInt(countStudent) + 1 + "");
        cookie.setMaxAge(0);
//        cookie.setPath("/");
        response.addCookie(cookie);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/list";
    }

//    @ExceptionHandler(Exception.class)
//    public String handleError() {
//        return "error";
//    }
//
//    @ExceptionHandler(FileNotFoundException.class)
//    public String handleErrorFileNot() {
//        return "error1";
//    }
}
