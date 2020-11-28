package com.example.moviecatalogservice.db.model;

public class Catalog {
    private int id;
    private String name;
    private String description;
    private int rating;

    public Catalog(int id, String name, String description, int rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public Catalog(){}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public int getId(){
        return id;
    }
}
