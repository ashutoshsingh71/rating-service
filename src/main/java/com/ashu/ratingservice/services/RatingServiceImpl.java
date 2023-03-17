package com.ashu.ratingservice.services;

import com.ashu.ratingservice.entities.Rating;
import com.ashu.ratingservice.exceptions.ResourceNotFoundException;
import com.ashu.ratingservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingFromUser(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!!" + ratingId));
    }

    @Override
    public void deleteRating(String ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    @Override
    public List<Rating> getRatingFromHotel(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
