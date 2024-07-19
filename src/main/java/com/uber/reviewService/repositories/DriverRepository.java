package com.uber.reviewService.repositories;

import com.uber.reviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

    @Query(nativeQuery = true, value = "SELECT * FROM DRIVER WHERE id = :id AND license_number = :licenseNumber")
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String licenseNumber);

}
