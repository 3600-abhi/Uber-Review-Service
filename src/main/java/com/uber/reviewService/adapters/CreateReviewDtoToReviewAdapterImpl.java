package com.uber.reviewService.adapters;

import com.uber.reviewService.dtos.CreateReviewDto;
import com.uber.reviewService.models.Booking;
import com.uber.reviewService.models.Review;
import com.uber.reviewService.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter {

    private final BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {
        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBookingId());

        return booking.map(value -> Review.builder()
                                          .rating(createReviewDto.getRating())
                                          .content(createReviewDto.getContent())
                                          .booking(value)
                                          .build()).orElse(null);

    }
}
