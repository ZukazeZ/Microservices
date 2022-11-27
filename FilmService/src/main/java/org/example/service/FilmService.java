package org.example.service;

import org.example.models.entity.FilmEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {
    List<FilmEntity> findallfilm();
    FilmEntity findById(Long id);
    FilmEntity updaterFilm(Long id, FilmEntity filmEntity);
    String deleteFilm(Long id);
    FilmEntity saveFilm(FilmEntity filmDto);
}