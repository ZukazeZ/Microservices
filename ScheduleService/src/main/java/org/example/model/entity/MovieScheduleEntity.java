package org.example.model.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "nt_movieSchedule")
@Entity
public class MovieScheduleEntity {
    @Id
    private String id;

    private String movieId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private ScheduleEntity scheduleId;
}
