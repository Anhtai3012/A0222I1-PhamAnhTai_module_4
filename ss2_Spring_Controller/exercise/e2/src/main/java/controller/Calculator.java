package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @RequestMapping(value = "/")
    public String home(){
    return "index";
}
@RequestMapping(value = "/realizable" , method = RequestMethod.POST)
    public String calculator(@RequestParam("number1") String number1, @RequestParam("number2") String number2, @RequestParam("calculator") String calculator, Model model){
        int result;

        switch (calculator){
            case "+":
                result = Integer.parseInt(number1)+Integer.parseInt(number2);
                break;
            case "-":
                result = Integer.parseInt(number1)-Integer.parseInt(number2);
                break;
            case "*":
                result = Integer.parseInt(number1)*Integer.parseInt(number2);
                break;
            case "/":
                result = Integer.parseInt(number1)/Integer.parseInt(number2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculator);
        }
        model.addAttribute("result",result);

        return "index";
}
}
