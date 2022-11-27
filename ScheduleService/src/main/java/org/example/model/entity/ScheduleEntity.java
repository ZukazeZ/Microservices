package org.example.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "nt_schedule")
@ToString
@Entity
public class ScheduleEntity implements Serializable {

    @Id
    private String id;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private Set<MovieScheduleEntity> movieSchedulesEntity;

    private LocalDate showDate;

    private LocalTime startTime;

    private LocalTime endTime;
}
