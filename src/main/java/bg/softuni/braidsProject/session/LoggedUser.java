package bg.softuni.braidsProject.session;

import bg.softuni.braidsProject.model.entity.Review;
import bg.softuni.braidsProject.model.entity.User;
import bg.softuni.braidsProject.model.entity.enums.UserRole;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Set;

@Component
@SessionScope
public class LoggedUser {
    private long id;

    private String firstName;

    private String lastName;
    private String email;
    private UserRole role;

    public void login(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.role = user.getRole();

    }

    public void logout(){
        this.id = 0;
        this.email = null;
        this.firstName = null;
        this.lastName = null;
        this.role = null;
    }


    public UserRole getRole() {
        return role;
    }
    public LoggedUser setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public long getId() {
        return id;
    }
    public LoggedUser setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }
    public LoggedUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public LoggedUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }
    public LoggedUser setEmail(String email) {
        this.email = email;
        return this;
    }
}
