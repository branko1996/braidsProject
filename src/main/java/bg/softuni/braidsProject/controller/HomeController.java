package bg.softuni.braidsProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String LoggedOutIndex(){
        return "index";
    }


    @GetMapping("/home")
    public String loggedInIndex(){
        return "index";
    }






}
