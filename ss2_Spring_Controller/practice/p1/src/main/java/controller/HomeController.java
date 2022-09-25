package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static final String EMAIL_REGEX="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;
    public HomeController(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping(value = "/")
    public String home(){
        return "home";
    }
    @RequestMapping(value = "/validate" ,method = RequestMethod.POST)
    public String user(@RequestParam("email") String email, ModelMap modelMap){
        boolean isValid=this.validate(EMAIL_REGEX);
        if (!isValid){
            modelMap.put("email","Email is invalid");
        }
        modelMap.addAttribute("Email",email);
        return "/successful";
    }
    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
