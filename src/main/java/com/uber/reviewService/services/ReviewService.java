package com.uber.reviewService.services;

import com.uber.reviewService.models.Review;
import com.uber.reviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Review review = Review
                            .builder()
                            .content("from mumbai to lucknow")
                            .rating(5.0)
                            .build();

        reviewRepository.save(review);
    }
}
