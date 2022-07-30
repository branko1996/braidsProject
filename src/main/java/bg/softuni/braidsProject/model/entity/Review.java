package bg.softuni.braidsProject.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review extends BaseEntity{

    @Column(columnDefinition = "text")
    private String text;

    @Column
    private LocalDateTime datePosted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Review() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }
    public Review setText(String text) {
        this.text = text;
        return this;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }
    public Review setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
        return this;
    }




}
