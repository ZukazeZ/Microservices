package org.example.repository;

import org.example.model.entity.MovieScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieScheduleRepository extends JpaRepository<MovieScheduleEntity, String> {
    List<MovieScheduleEntity> findMovieScheduleById(String movieId);
}
