package com.ashu.ratingservice.services;

import com.ashu.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating createRating(Rating rating);
    //get all ratings
    List<Rating> getAllRatings();
    //get ratings from userId
    List<Rating> getRatingFromUser(String userId);
    //get ratings from hotel id
    List<Rating> getRatingFromHotel(String hotelId);
    Rating getRatingById(String ratingId);
    void deleteRating(String ratingId);
}
