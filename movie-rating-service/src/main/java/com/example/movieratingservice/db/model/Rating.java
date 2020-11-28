package com.example.movieratingservice.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {
    @Id @NonNull
    private int id;
    private int rating;

    public Rating(
            @JsonProperty("id") int id,
            @JsonProperty("rating") int rating) {
        this.id = id;
        this.rating = rating;
    }

    public Rating(){}

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }
}
