package bg.softuni.braidsProject.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    public Picture() {
    }

    public String getTitle() {
        return title;
    }

    public Picture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Picture setDescription(String description) {
        this.description = description;
        return this;
    }
}
