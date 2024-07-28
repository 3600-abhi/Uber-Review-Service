package com.uber.reviewService.repositories;

import com.uber.reviewService.models.Booking;
import com.uber.reviewService.models.Driver;
import com.uber.reviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
