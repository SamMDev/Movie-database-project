package com.example.movieratingservice.controller;

import com.example.movieratingservice.api.dto.RatingDto;
import com.example.movieratingservice.db.model.Rating;
import com.example.movieratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;
    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    /**
     * gets rating by id
     * @param id
     * @return rating with current id
     */
    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RatingDto getRating(
        @PathVariable("id") int id
    ){
        return ratingService.getRating(id);
    }

    /**
     * Inserts given rating
     * @param rating
     */
    @PostMapping(
            path = "/insert"
    )
    public void insertRating(
            @RequestBody Rating rating){
        ratingService.insertRating(rating);
    }


    /**
     * Shows port application is running on
     * @param port
     * @return
     */

    @GetMapping(
            path = "/port"
    )
    public String getPort(
            @Value("${server.port}") String port
    ){
        return port;
    }
}
