package lab4.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bai4 {
    @RequestMapping("/home/index") 
    public String index(Model model) { 
    return "home/index"; 
    } 

    @RequestMapping("/home/about") 
        public String about(Model model) { 
        return "home/about"; 
    }
}
