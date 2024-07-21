package com.uber.reviewService.repositories;

import com.uber.reviewService.models.Booking;
import com.uber.reviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<List<Booking>> findAllByDriverId(Long driverId);

    Optional<List<Booking>> findAllByDriverIn(List<Driver> drivers);
}
