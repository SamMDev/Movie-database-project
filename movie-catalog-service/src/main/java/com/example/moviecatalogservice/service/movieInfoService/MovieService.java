package com.example.moviecatalogservice.service.movieInfoService;

import com.example.moviecatalogservice.api.dto.MovieDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Value("${movie-info-service}")
    private String url;

    private final RestTemplate restTemplate;
    @Autowired
    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Gets movie by its id
     *
     * Fallback: If server is down or slow, returns hardcoded movie
     *
     * @param id    given id of movie
     * @return      movie with such id (or null if does not exists)
     */
    @HystrixCommand(fallbackMethod = "getFallbackMovie")
    public MovieDto getMovie(int id){
        return
                restTemplate.getForObject(url + id, MovieDto.class);
    }
    public MovieDto getFallbackMovie(int id){
        return new MovieDto(id,
                            "NO MOVIE NAME FOUND",
                            "There was a problem finding movie name"
                            );
    }


    /**
     * inserts movie into database
     *
     * @param movie
     */
    public void insertMovie(MovieDto movie){
        restTemplate.postForEntity(url + "/insert", movie, MovieDto.class);
    }
}
