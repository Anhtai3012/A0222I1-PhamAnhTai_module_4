package codegym.controller;

import codegym.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("config")
    public ModelAndView config(){
        ModelAndView modelAndView= new ModelAndView("config", "setting", setting);
        return modelAndView;
    }

    @PostMapping("save")
    public String save(Setting s){
        setting= s;
        return "home";
    }
}
