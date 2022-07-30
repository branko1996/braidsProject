package bg.softuni.braidsProject.model.entity;

import bg.softuni.braidsProject.model.entity.enums.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String email;

//    @ManyToOne
//    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role = UserRole.USER;

    @ManyToMany
    private Set<Picture> pictures;



    public User() {
        this.pictures = new HashSet<>();

    }




    public String getFirstName() {
        return firstName;
    }
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


    public String getLastName() {
        return lastName;
    }
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public String getPassword() {
        return password;
    }
    public User setPassword(String password) {
        this.password = password;
        return this;
    }


    public String getEmail() {
        return email;
    }
    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserRole getRole() {
        return role;
    }
    public User setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }
    public User setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
