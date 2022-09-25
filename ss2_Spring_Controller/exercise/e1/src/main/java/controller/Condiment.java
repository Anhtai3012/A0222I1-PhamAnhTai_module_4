package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Condiment {
    @RequestMapping(value = "/")
    public String condiment(){
        return "/index";
    }
    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        List<String> result = new ArrayList<>();
        for (String rs:condiment) {
            result.add(rs);
        }
            model.addAttribute("result",result);
        return "index";
    }
}
