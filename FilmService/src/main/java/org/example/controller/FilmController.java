package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.models.entity.FilmEntity;
import org.example.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    FilmService filmService;

    @Operation(summary="This is create new information into db")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "put film into DB",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    }
    )
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public FilmEntity create(@RequestBody FilmEntity film){
        return filmService.saveFilm(film);
    }
    @Operation(summary="This is get all information from db")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "get all information from DB",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    }
    )
    @GetMapping("/getall")
    public List<FilmEntity> getall(){
        return filmService.findallfilm();
    }
    @Operation(summary="This is to update specified information from db")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "update information from DB",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    }
    )
    @PutMapping("/update/{id}")
    public FilmEntity update(@PathVariable Long id, @RequestBody FilmEntity films){
        return filmService.updaterFilm(id,films);
    }
    @Operation(summary="This is to delete specified film from db")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "deleted film from DB",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    }
    )
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return filmService.deleteFilm(id);
    }
}
