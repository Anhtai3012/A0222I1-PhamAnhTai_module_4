package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Conversion {
@GetMapping("/cunrrency")
public String home(){
    return "cunrrency";
}
@GetMapping("/conversion")
    public String conversion(Model model, @RequestParam("number") String usa){
    double result = Double.parseDouble(usa)*23000;
    model.addAttribute("result",result);
    return"result";
}

}
