package com.uber.reviewService.repositories;

import com.uber.reviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

    Optional<List<Driver>> findAllByIdIn(List<Long> driverIds);


    // when nativeQuery is true then it is MySQL Query otherwise hibernate query
//    @Query(nativeQuery = true, value = "SELECT * FROM DRIVER WHERE id = :id AND license_number = :licenseNumber")
//    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String licenseNumber);


    // by default, it is a hibernate query
//    @Query(value = "SELECT d FROM Driver as d WHERE d.id = :id AND d.licenseNumber = :licenseNumber")
//    Optional<Driver> hqlFindByIdAndLicenseNumber(Long id, String licenseNumber);

}
