package com.example.moviecatalogservice.service.ratingService;

import com.example.moviecatalogservice.api.dto.RatingDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingService {

    @Value("${movie-rating-service}")
    private String url;

    private final RestTemplate restTemplate;
    @Autowired
    public RatingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Gets rating by its id
     *
     * Fallback: If server is down or slow, returns hardcoded rating
     *
     * @param id    given id of rating
     * @return      rating with such id (or null if does not exists)
     */
    @HystrixCommand(fallbackMethod = "getFallbackRating")
    public RatingDto getRating(int id){
        return
                restTemplate.getForObject(url + id, RatingDto.class);
    }
    public RatingDto getFallbackRating(int id){
        return new RatingDto(
                id,
                0
        );
    }


    /**
     * Inserts rating into database
     *
     * @param rating
     */
    public void insertRating(RatingDto rating){
        restTemplate.postForEntity(url + "/insert", rating, RatingDto.class);
    }

}
