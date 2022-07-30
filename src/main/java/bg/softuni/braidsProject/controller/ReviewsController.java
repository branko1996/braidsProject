package bg.softuni.braidsProject.controller;

import bg.softuni.braidsProject.model.dto.ReviewDTO;
import bg.softuni.braidsProject.service.AuthService;
import bg.softuni.braidsProject.service.ReviewService;
import bg.softuni.braidsProject.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ReviewsController {
    private AuthService authService;
    private LoggedUser userSession;
    private ReviewService reviewService;

    public ReviewsController(AuthService authService, LoggedUser userSession, ReviewService reviewService) {
        this.authService = authService;
        this.userSession = userSession;
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public String reviews(){
        return "reviews";
    }

    @ModelAttribute("reviewDTO")
    public ReviewDTO initReviewDTO(){
        return new ReviewDTO();
    }

    @PostMapping("/reviews")
    public String review(@Valid ReviewDTO reviewDTO,
                         BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "redirect:/reviews";
        }
        this.reviewService.addReview(reviewDTO);

        return "redirect:/home";
    }
}
