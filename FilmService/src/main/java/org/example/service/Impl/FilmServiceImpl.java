package org.example.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.models.entity.FilmEntity;
import org.example.repository.FilmRepository;
import org.example.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;



    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    @Override
    public List<FilmEntity> findallfilm() {
        return filmRepository.findAll();
    }

    @Override
    public FilmEntity findById(Long id) {
        Optional<FilmEntity> search = filmRepository.findById(id);
        if(search.isPresent()) {
            log.info("updated!");
            return search.get();
        }
        else{
            log.error("No such movie existed");
            return null;
        }

    }

    @Override
    public FilmEntity saveFilm(FilmEntity filmDto) {
        return filmRepository.save(filmDto);
    }


    @Override
    public FilmEntity updaterFilm(Long id, FilmEntity filmEntity) {
        FilmEntity film = findById(id);
        if (film != null) {
            log.info("Updating");
            film.setFilmName(filmEntity.getFilmName());
            film.setFilmStatus(filmEntity.getFilmStatus());
            film.setFilmDuration(filmEntity.getFilmDuration());
            film.setGenre(filmEntity.getGenre());
            filmRepository.saveAndFlush(film);
        }
        return film;
    }


    public String deleteFilm(Long id) {
        filmRepository.deleteById(id);
        return "Film Has Been Deleted";
    }
}
