package bg.softuni.braidsProject.service;

import bg.softuni.braidsProject.model.dto.ReviewDTO;
import bg.softuni.braidsProject.model.entity.Review;
import bg.softuni.braidsProject.repository.ReviewRepository;
import bg.softuni.braidsProject.repository.UserRepository;
import bg.softuni.braidsProject.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    private final LoggedUser userSession;

    public ReviewService(UserRepository userRepository, ReviewRepository reviewRepository, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.userSession = userSession;
    }

    public void addReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setDatePosted(LocalDateTime.now());
        review.setText(reviewDTO.getText());
        review.setUser(this.userRepository.findByEmail(userSession.getEmail()).get());

       this.reviewRepository.save(review);

    }
}
