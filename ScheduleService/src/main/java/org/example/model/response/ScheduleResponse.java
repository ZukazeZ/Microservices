package org.example.model.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleResponse {
    private String id;

    private String movieId;

    private LocalDate showDate;

    private LocalTime startTime;

    private LocalTime endTime;
}
