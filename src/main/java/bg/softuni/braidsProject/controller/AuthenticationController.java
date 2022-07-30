package bg.softuni.braidsProject.controller;

import bg.softuni.braidsProject.model.dto.LoginDTO;
import bg.softuni.braidsProject.model.dto.UserRegistrationDTO;
import bg.softuni.braidsProject.service.AuthService;
import bg.softuni.braidsProject.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    private AuthService authService;
    private LoggedUser userSession;

    public AuthenticationController(AuthService authService, LoggedUser userSession) {
        this.authService = authService;
        this.userSession = userSession;
    }

    @ModelAttribute("registrationDTO")
    public UserRegistrationDTO initRegistrationDTO(){
        return new UserRegistrationDTO();
    }

    @ModelAttribute("loginDTO")
    public LoginDTO initLoginDTO(){
        return new LoginDTO();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO registrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors() || !this.authService.register(registrationDTO)){
            redirectAttributes.addFlashAttribute("registrationDTO",registrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registrationDTO", bindingResult);

            return "redirect:/register";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@Valid LoginDTO loginDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginDTO",loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/login";
        }

        if (!this.authService.login(loginDTO)){
            redirectAttributes.addFlashAttribute("loginDTO",loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials",true);

            return "redirect:/login";
        }


        return "redirect:/home";

    }

    @GetMapping("/logout")
    public String logout(){
        this.userSession.logout();
        return "redirect:/home";
    }
}
