package com.example.movieinfoservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDto {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    public MovieDto(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public MovieDto(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
