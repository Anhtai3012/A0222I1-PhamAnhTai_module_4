package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Dictionary {
    String viet [] = {"xin chao","tam biet","hen gap lai"};
    String english [] = {"hello","good bye","see you again"};
    @GetMapping("")
    public String dictionary(){
        return"/index";
    }
   // value = "/getUserDetails", method = RequestMethod.GET
    @RequestMapping(value = "/index" , method = RequestMethod.POST)
    public String search(Model model,@RequestParam("dictionary") String dic){
        for (int i = 0; i <english.length ; i++) {
            if (dic.equals(english[i])){
                model.addAttribute("result",viet[i]);
            }
        }
        return "index";
    }
}
