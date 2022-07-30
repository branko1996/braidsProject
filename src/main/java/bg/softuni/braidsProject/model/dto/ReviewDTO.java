package bg.softuni.braidsProject.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ReviewDTO {
    @NotBlank
    private String text;



    public ReviewDTO() {
    }

    public String getText() {
        return text;
    }

    public ReviewDTO setText(String text) {
        this.text = text;
        return this;
    }


}
