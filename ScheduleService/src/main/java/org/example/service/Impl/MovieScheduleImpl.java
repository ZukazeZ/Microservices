package org.example.service.Impl;

import org.example.config.DataNotFoundException;
import org.example.model.entity.MovieScheduleEntity;
import org.example.model.entity.ScheduleEntity;
import org.example.model.request.MovieScheduleRequest;
import org.example.model.response.MovieScheduleResponse;
import org.example.repository.MovieScheduleRepository;
import org.example.repository.ScheduleRepository;
import org.example.service.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MovieScheduleImpl implements MovieScheduleService {
@Autowired
    private  MovieScheduleRepository movieScheduleRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    public MovieScheduleImpl(MovieScheduleRepository movieScheduleRepository, ScheduleRepository scheduleRepository) {
        this.movieScheduleRepository = movieScheduleRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<MovieScheduleResponse> add(List<MovieScheduleRequest> movieScheduleRequests) {
        List<MovieScheduleResponse> movieScheduleResponses = new ArrayList<>();
        movieScheduleRequests.stream().forEach(movieRequest -> {
                    ScheduleEntity schedule = scheduleRepository.findById(movieRequest.getScheduleId())
                            .orElseThrow(() -> new DataNotFoundException(String.format("scheule with id %s not found", movieRequest.getScheduleId())));
                    MovieScheduleEntity movieSchedule = MovieScheduleEntity.builder()
                            .id(UUID.randomUUID().toString())
                            .movieId(movieRequest.getIdMovie())
                            .scheduleId(schedule)
                            .build();
                    movieScheduleRepository.save(movieSchedule);

                    MovieScheduleResponse movieScheduleResponse = MovieScheduleResponse.builder()
                            .id(schedule.getId())
                            .movieId(movieSchedule.getMovieId())
                            .schedule(schedule)
                            .build();

                    movieScheduleResponses.add(movieScheduleResponse);
                }
        );
        return movieScheduleResponses;
    }


    @Override
    public List<MovieScheduleResponse> findMovieScheduleByMovieId(String movieId) {
        if (movieId == null) {
            throw new DataNotFoundException("movie id is null");
        }

        List<MovieScheduleEntity> movieScheduleResponseRequest = movieScheduleRepository.findMovieScheduleById(movieId);
        if (movieScheduleResponseRequest.get(0) == null) {
            throw new DataNotFoundException("data movie schedule response is null");
        }

        List<MovieScheduleResponse> movieScheduleResponses = new ArrayList<>();
        movieScheduleResponseRequest.stream().forEach(response -> {
            MovieScheduleResponse movieScheduleResponse = MovieScheduleResponse.builder()
                    .id(response.getId())
                    .movieId(response.getMovieId())
                    .schedule(response.getScheduleId())
                    .build();
            movieScheduleResponses.add(movieScheduleResponse);
        });

        return movieScheduleResponses;
    }


}
