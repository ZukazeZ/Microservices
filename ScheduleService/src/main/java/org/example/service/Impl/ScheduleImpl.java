package org.example.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.config.DataNotFoundException;
import org.example.model.entity.ScheduleEntity;
import org.example.model.request.ScheduleRequest;
import org.example.model.response.ScheduleResponse;
import org.example.repository.ScheduleRepository;
import org.example.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@Slf4j
public class ScheduleImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;


    public ScheduleImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<ScheduleResponse> add(List<ScheduleRequest> scheduleRequest) {
        List<ScheduleEntity> schedules = new ArrayList<>();
        scheduleRequest.stream().forEach(
                request -> {
                    ScheduleEntity schedule = ScheduleEntity.builder()
                            .id(request.getMovieId())
                            .showDate(request.getShowDate())
                            .startTime(request.getStartTime())
                            .endTime(request.getEndTime())
                            .build();
                    schedules.add(schedule);
                }
        );

        scheduleRepository.saveAll(schedules);

        List<ScheduleResponse> scheduleResponses = new ArrayList<>();
        schedules.stream().forEach(
                response -> {
                    ScheduleResponse scheduleResponse = ScheduleResponse.builder()
                            .id(response.getId())
                            .showDate(response.getShowDate())
                            .startTime(response.getStartTime())
                            .endTime(response.getEndTime())
                            .build();
                    scheduleResponses.add(scheduleResponse);
                }
        );
        return scheduleResponses;
    }

    @Override
    public ScheduleResponse findScheduleById(String scheduleId) {
        if (scheduleId == null) {
            log.error("schedule id is null");
        }

        ScheduleEntity schedules = scheduleRepository.findById(scheduleId).get();
        return ScheduleResponse.builder()
                .id(schedules.getId())
                .build();
    }
}
