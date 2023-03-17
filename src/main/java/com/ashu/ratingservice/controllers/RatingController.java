package com.ashu.ratingservice.controllers;

import com.ashu.ratingservice.entities.Rating;
import com.ashu.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    //creat rating
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingFromUser(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingFromHotel(hotelId));
    }

    @PutMapping("/update/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId,@RequestBody Rating rating){
        Rating ratingById = ratingService.getRatingById(ratingId);
        ratingById.setRating(rating.getRating());
        ratingById.setFeedback(rating.getFeedback());
        ratingById.setUserId(rating.getUserId());
        ratingById.setHotelId(rating.getHotelId());
        ratingService.createRating(ratingById);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingById);
    }

    @DeleteMapping("/delete/{ratingId}")
    public String deleteRating(@PathVariable String ratingId){
        ratingService.deleteRating(ratingId);
        return "Rating deleted!!";
    }

}
