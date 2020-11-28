package com.example.moviecatalogservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDto {
    private int id;
    private String name;
    private String description;

    public MovieDto(@JsonProperty("id") int id,
                    @JsonProperty("name") String name,
                    @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

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
