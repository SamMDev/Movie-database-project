package com.example.movieinfoservice.service;


import com.example.movieinfoservice.api.dto.MovieDto;
import com.example.movieinfoservice.db.model.Movie;
import com.example.movieinfoservice.db.repo.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ObjectMapper objectMapper;
    @Autowired
    public MovieService(MovieRepository movieRepository, ObjectMapper objectMapper) {
        this.movieRepository = movieRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Gets movie by id if exists, else null
     *
     * @param id
     * @return
     */
    public MovieDto getMovieById(int id){
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isPresent()) return objectMapper.convertValue(movie.get(), MovieDto.class);
        else return null;
    }
}
