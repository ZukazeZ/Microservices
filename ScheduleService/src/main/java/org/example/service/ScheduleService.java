package org.example.service;


import org.example.model.request.ScheduleRequest;
import org.example.model.response.ScheduleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    List<ScheduleResponse> add(List<ScheduleRequest> scheduleRequest);

    ScheduleResponse findScheduleById(String scheduleId);
}
