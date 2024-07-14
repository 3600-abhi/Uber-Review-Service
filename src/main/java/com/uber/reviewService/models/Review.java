package com.uber.reviewService.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "bookingReview")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Double rating;
}
