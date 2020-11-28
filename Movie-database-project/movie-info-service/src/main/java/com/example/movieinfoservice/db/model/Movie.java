package com.example.movieinfoservice.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_info")
public class Movie {
    @Id @NonNull
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    public Movie(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Movie(){}

}
