package org.example.models.request;

import lombok.*;
import org.example.models.entity.FilmEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class FilmUpdate {

    @Size(min = 2, max = 100, message = "The length of name must be between 2 and 100 characters.")
    private String filmName;
    private boolean filmStatus;
    private String age;
    private String filmDuration;
    private String genre;

    public FilmEntity toFilm() {
        return FilmEntity.builder()
                .filmName(this.filmName)
                .filmStatus(this.filmStatus)
                .filmDuration(this.filmDuration)
                .build();
    }
}
