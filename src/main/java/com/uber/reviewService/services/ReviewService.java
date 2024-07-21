package com.uber.reviewService.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uber.reviewService.enums.BookingStatus;
import com.uber.reviewService.models.Booking;
import com.uber.reviewService.models.Driver;
import com.uber.reviewService.models.Review;
import com.uber.reviewService.repositories.BookingRepository;
import com.uber.reviewService.repositories.DriverRepository;
import com.uber.reviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }


    @Override
    @Transactional
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

        List<Long> driverIds = List.of(1L, 2L, 3L, 4L, 5L);


        List<Driver> driverList = driverRepository.findAllById(driverIds);

        for(Driver driver : driverList) {
            List<Booking> bookingList = driver.getBookings();

            System.out.println("bookingSize = " + driver.getBookings().size());
        }

        System.out.println("driverName = " + driverList.get(0).getBookings().get(0).getDriver().getName());

    }
}
