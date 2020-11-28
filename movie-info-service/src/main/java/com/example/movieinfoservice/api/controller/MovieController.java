package com.example.movieinfoservice.api.controller;

import com.example.movieinfoservice.api.dto.MovieDto;
import com.example.movieinfoservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    /**
     * Gets movie by id
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public MovieDto getMovieById(
            @PathVariable("id") int id
    ){
        return movieService.getMovieById(id);
    }
}
