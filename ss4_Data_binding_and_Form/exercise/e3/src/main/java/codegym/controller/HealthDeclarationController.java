package codegym.controller;

import codegym.model.HealthDeclaration;
import codegym.service.HealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HealthDeclarationController {

    private HealthDeclarationService healthDeclarationService;

    @GetMapping("list")
    public String list(Model model){
        List<HealthDeclaration> res = healthDeclarationService.findAll();
        model.addAttribute("res", res);
        return "list";
    }

    @GetMapping(path= {"/form", "/form/{id}"})
    public ModelAndView form(@PathVariable(required = false) Optional<Integer> id){
        HealthDeclaration res = new HealthDeclaration();

        if(id.isPresent()){
            Optional<HealthDeclaration> optionalHealthDeclaration = healthDeclarationService.findById(id.get());
            if(optionalHealthDeclaration.isPresent()){
                res = optionalHealthDeclaration.get();
            }
        }

        ModelAndView modelAndView= new ModelAndView("form", "result", res);
        return modelAndView;
    }

    @PostMapping("save")
    public String save(HealthDeclaration healthDeclaration){
        healthDeclarationService.save(healthDeclaration);
        return "redirect:/list";
    }
}
