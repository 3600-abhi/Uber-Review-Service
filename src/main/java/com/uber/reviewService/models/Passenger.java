package com.uber.reviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {
    private String name;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>();
}
