package com.uber.reviewService.services;

import com.uber.reviewService.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public Review createReview(Review review);

    public Optional<Review> findReviewById(Long id);

    public List<Review> findAllReviews();

    public boolean deleteReviewById(Long id);
}
