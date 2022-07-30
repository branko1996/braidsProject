package bg.softuni.braidsProject.service;

import bg.softuni.braidsProject.model.dto.LoginDTO;
import bg.softuni.braidsProject.model.dto.ReviewDTO;
import bg.softuni.braidsProject.model.dto.UserRegistrationDTO;
import bg.softuni.braidsProject.model.entity.Review;
import bg.softuni.braidsProject.model.entity.User;
import bg.softuni.braidsProject.repository.UserRepository;
import bg.softuni.braidsProject.session.LoggedUser;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final LoggedUser userSession;


    public AuthService(UserRepository userRepository, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean register(UserRegistrationDTO registrationDTO){
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())){
            return false;
        }

        // duplicate email
        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        if (byEmail.isPresent()){
            return false;
        }


        User user = new User();
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());


        this.userRepository.save(user);


        return true;
    }


    public boolean login(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());

        if (user.isEmpty()){
            return false;
        }

        this.userSession.login(user.get());

        return true;
    }


}
