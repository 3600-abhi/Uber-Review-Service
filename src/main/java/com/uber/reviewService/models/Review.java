package com.uber.reviewService.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Builder
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Double rating;
}
