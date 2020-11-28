package com.example.movieratingservice.service;


import com.example.movieratingservice.api.dto.RatingDto;
import com.example.movieratingservice.db.model.Rating;
import com.example.movieratingservice.db.repo.RatingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final ObjectMapper objectMapper;
    @Autowired
    public RatingService(RatingRepository ratingRepository, ObjectMapper objectMapper) {
        this.ratingRepository = ratingRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Gets rating with current id
     * @param id
     * @return
     */
    public RatingDto getRating(int id){
        Optional<Rating> rating = ratingRepository.findById(id);
        if(rating.isPresent()) return objectMapper.convertValue(rating.get(), RatingDto.class);
        else return null;
    }


    /**
     * inserts rating into database
     * @param rating
     */
    public void insertRating(Rating rating){
        ratingRepository.save(rating);
    }
}
