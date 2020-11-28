package com.example.moviecatalogservice.service;

import com.example.moviecatalogservice.api.dto.MovieDto;
import com.example.moviecatalogservice.api.dto.RatingDto;
import com.example.moviecatalogservice.db.model.Catalog;
import com.example.moviecatalogservice.service.movieInfoService.MovieService;
import com.example.moviecatalogservice.service.ratingService.RatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {

    private final RatingService ratingService;
    private final MovieService movieService;
    @Autowired
    public CatalogService(RatingService ratingService, MovieService movieService) {
        this.ratingService = ratingService;
        this.movieService = movieService;
    }


    /**
     * Gets catalog by id
     *
     * returns fallback catalog object if not found by id
     *
     * @param id    id of catalog
     * @return      catalog object
     */
    public Catalog getCatalog(int id){
        MovieDto movie = movieService.getMovie(id);
        RatingDto rating = ratingService.getRating(id);

        try{
            return new Catalog(
                    movie.getId(),
                    movie.getName(),
                    movie.getDescription(),
                    rating.getRating()
            );
        }catch (NullPointerException e){
            return new Catalog(
                    id,
                    "NO CATALOG FOUND",
                    "There is no catalog with such id",
                    0
            );
        }
    }


    /**
     * Inserts catalog object
     *
     * @param catalog
     */
    public void insertCatalog(Catalog catalog){

        //inserts movie created from catalog into database
        movieService.insertMovie(
                new MovieDto(
                        catalog.getId(),
                        catalog.getName(),
                        catalog.getDescription()
                )
        );

        //inserts rating created from catalog into database
        ratingService.insertRating(
                new RatingDto(
                        catalog.getId(),
                        catalog.getRating()
                )
        );
    }
}
