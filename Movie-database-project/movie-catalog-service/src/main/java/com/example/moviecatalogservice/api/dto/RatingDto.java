package com.example.moviecatalogservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingDto {

    private int id;
    private int rating;

    public RatingDto(
            @JsonProperty("id") int id,
            @JsonProperty("rating") int rating) {
        this.id = id;
        this.rating = rating;
    }

    public RatingDto(){}

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }
}
