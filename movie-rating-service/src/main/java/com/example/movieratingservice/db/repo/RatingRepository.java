package com.example.movieratingservice.db.repo;


import com.example.movieratingservice.db.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
