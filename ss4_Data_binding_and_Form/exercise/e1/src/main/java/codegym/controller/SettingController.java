package codegym.controller;

import codegym.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    private static Setting setting= new Setting();

    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView= new ModelAndView("home");
        return modelAndView;
    }

    @GetMapping("/config")
    public String config(Model model ){
        model.addAttribute("setting",new Setting("",0,true,""));
        return "/config";
    }

    @PostMapping("save")
    public String save(Setting s){
        setting= s;
        return "home";
    }
}
