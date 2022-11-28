package com.codegym.furama.controller;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.model.employee.Position;
import com.codegym.furama.service.employee.IDivisionService;
import com.codegym.furama.service.employee.IEducationDegreeService;
import com.codegym.furama.service.employee.IEmployeeService;
import com.codegym.furama.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IPositionService positionService;

    @ModelAttribute("educationDegrees")
    public List<EducationDegree> educationDegrees(){
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public List<Division> divisions(){
        return divisionService.findAll();
    }

    @ModelAttribute("positions")
    public List<Position> positions(){
        return positionService.findAll();
    }

    @GetMapping("")
    public String list(Model model,@RequestParam(value = "name", defaultValue = "") String name,
                               @PageableDefault(size = 3, sort = "name", direction = Sort.Direction.ASC) Pageable pageable){
        model.addAttribute("list",employeeService.findAllByName(name,pageable));
        model.addAttribute("name_search",name);
        return "employee/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("employee",new Employee());
        return "employee/form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","successful");
        employeeService.save(employee);
        return "redirect:/employee";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","successful");
        employeeService.remove(id);
        return "redirect:/employee";
    }
}
