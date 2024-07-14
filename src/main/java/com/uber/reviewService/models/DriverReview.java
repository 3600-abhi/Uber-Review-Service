package com.uber.reviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "driverReviewId")
@Getter
@Setter
public class DriverReview extends Review {
    private String driverReviewComment;
}
