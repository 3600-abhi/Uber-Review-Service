package com.uber.reviewService.services;

import com.uber.reviewService.enums.BookingStatus;
import com.uber.reviewService.models.Booking;
import com.uber.reviewService.models.Review;
import com.uber.reviewService.repositories.BookingRepository;
import com.uber.reviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }


    @Override
    public void run(String... args) throws Exception {

//        Review review = Review
//                .builder()
//                .content("from mumbai to lucknow")
//                .rating(5.0)
//                .build();
//
//
//        Booking booking = Booking
//                .builder()
//                .review(review)
//                .bookingStatus(BookingStatus.ASSIGNING_DRIVER)
//                .build();
//
//        bookingRepository.save(booking);

        bookingRepository.deleteById(2L);


    }
}
