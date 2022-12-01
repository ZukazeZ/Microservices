package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.config.DataNotFoundException;
import org.example.model.request.MovieScheduleRequest;
import org.example.model.request.ScheduleRequest;
import org.example.model.response.MovieScheduleResponse;
import org.example.model.response.ScheduleResponse;
import org.example.model.response.WebResponse;
import org.example.service.MovieScheduleService;
import org.example.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    private final MovieScheduleService movieScheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService, MovieScheduleService movieScheduleService) {
        this.scheduleService = scheduleService;
        this.movieScheduleService = movieScheduleService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<WebResponse<List<ScheduleResponse>>> createSchedule(@RequestBody List<ScheduleRequest> scheduleRequest) {
        log.info("Creating");
        try {
            List<ScheduleResponse> scheduleResponses = scheduleService.add(scheduleRequest);
            WebResponse<List<ScheduleResponse>> webResponse = new WebResponse<>(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    scheduleResponses
            );
            log.info("Created");
            return new ResponseEntity<>(webResponse, HttpStatus.OK);
        } catch (Exception exception) {
            log.error("error {} ", exception.getMessage());
            WebResponse<List<ScheduleResponse>> webResponse = new WebResponse<>(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    null
            );
            return new ResponseEntity<>(webResponse, HttpStatus.OK);
        }
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<WebResponse<List<MovieScheduleResponse>>> saveMovieSchedule(@RequestBody List<MovieScheduleRequest> movieScheduleRequests) {
        log.info("Saving file");
        try {
            List<MovieScheduleResponse> scheduleResponses = movieScheduleService.add(movieScheduleRequests);
            WebResponse<List<MovieScheduleResponse>> webResponse = new WebResponse<>(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    scheduleResponses
            );
            log.info("Saved");
            return new ResponseEntity<>(webResponse, HttpStatus.OK);
        } catch (Exception exception) {
            log.error("error {} ", exception.getMessage());
            WebResponse<List<MovieScheduleResponse>> webResponse = new WebResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    null
            );
            return new ResponseEntity<>(webResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<WebResponse<List<MovieScheduleResponse>>> findMovieScheduleByMovieId(@PathVariable("id") String id) {
        log.info("Getting information");
        try {
            List<MovieScheduleResponse> movieScheduleResponses = movieScheduleService.findMovieScheduleByMovieId(id);
            WebResponse<List<MovieScheduleResponse>> webResponse = new WebResponse<>(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    movieScheduleResponses
            );
            log.info("information got");
            return new ResponseEntity<>(webResponse, HttpStatus.OK);
        }catch (Exception exception) {
            log.error("error {} ", exception.getMessage());
            WebResponse<List<MovieScheduleResponse>> webResponse = new WebResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    null
            );
            return new ResponseEntity<>(webResponse, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-schedule/{id}")
    @ResponseBody
    public ResponseEntity<WebResponse<ScheduleResponse>> findScheduleById(@PathVariable("id") String scheduleId) {
        log.info("Getting specific schedule");
        try {
            ScheduleResponse scheduleResponse = scheduleService.findScheduleById(scheduleId);
            WebResponse webResponse = new WebResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    scheduleResponse
            );
            log.info("Schedule get");
            return new ResponseEntity<>(webResponse, HttpStatus.OK);
        }catch (DataNotFoundException exception) {
            log.error("error {} ", exception.getMessage());
            WebResponse webResponse = new WebResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    null
            );

            return new ResponseEntity<>(webResponse, HttpStatus.NOT_FOUND);
        }
    }
}
