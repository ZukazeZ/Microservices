package org.example.models.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class FilmRequest {

    @NotEmpty(message = "The filmName is required.")
    @Size(min = 2, max = 100, message = "The length of full title must be between 2 and 100 characters.")
    private String filmName;
    private String filmStatus;
    private String filmDuration;
    private String genre;



}
