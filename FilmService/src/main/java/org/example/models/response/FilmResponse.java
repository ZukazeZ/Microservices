package org.example.models.response;

import lombok.*;

import javax.persistence.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmResponse {
    private String filmCode;
    private String filmName;
    private Boolean filmStatus;
    private String filmDuration;
    private String genre;
}