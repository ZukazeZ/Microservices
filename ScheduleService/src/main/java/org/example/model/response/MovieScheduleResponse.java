package org.example.model.response;

import lombok.*;
import org.example.model.entity.ScheduleEntity;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieScheduleResponse {
    private String id;

    private String movieId;

    private ScheduleEntity schedule;
}
