package org.example.models.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "nt_Films")
@SQLDelete(sql = "UPDATE films SET deleted = TRUE WHERE id = ?")
@Where(clause = "deleted=false")


public class FilmEntity {
    @Id
    private long id;
    private String filmCode;
    private String filmName;
    @Column(name="status",columnDefinition = "boolean default true")
    private Boolean filmStatus;
    private String filmDuration;
    private String genre;
}
