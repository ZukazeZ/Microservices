package org.example.service;

import org.example.model.request.MovieScheduleRequest;
import org.example.model.response.MovieScheduleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieScheduleService {

    List<MovieScheduleResponse> add(List<MovieScheduleRequest>  movieScheduleRequests);

    List<MovieScheduleResponse> findMovieScheduleByMovieId(String movieId);
}
