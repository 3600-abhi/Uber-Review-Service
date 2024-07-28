package com.uber.reviewService.controllers;

import com.uber.reviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.uber.reviewService.dtos.CreateReviewDto;
import com.uber.reviewService.dtos.ReviewDto;
import com.uber.reviewService.models.Review;
import com.uber.reviewService.services.ReviewService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    public ReviewController(ReviewService reviewService, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody CreateReviewDto createReviewDto) {
        Review incomingReview = this.createReviewDtoToReviewAdapter.convertDto(createReviewDto);

        if (incomingReview == null) {
            return new ResponseEntity<>("Invalid arguments", HttpStatus.BAD_REQUEST);
        }

        Review review = this.reviewService.createReview(incomingReview);

        ReviewDto response = ReviewDto.builder()
                                      .id(review.getId())
                                      .content(review.getContent())
                                      .rating(review.getRating())
                                      .booking(review.getBooking().getId())
                                      .createdAt(review.getCreatedAt())
                                      .updatedAt(review.getUpdatedAt())
                                      .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> fetchAllReviews() {
        List<Review> reviewList = this.reviewService.findAllReviews();

        List<ReviewDto> response = new ArrayList<>();

        for (Review review : reviewList) {
            ReviewDto reviewDto = ReviewDto.builder()
                                           .id(review.getId())
                                           .content(review.getContent())
                                           .rating(review.getRating())
                                           .booking(review.getBooking().getId())
                                           .createdAt(review.getCreatedAt())
                                           .updatedAt(review.getUpdatedAt())
                                           .build();

            response.add(reviewDto);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
