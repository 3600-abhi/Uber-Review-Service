package com.uber.reviewService.adapters;

import com.uber.reviewService.dtos.CreateReviewDto;
import com.uber.reviewService.models.Review;

public interface CreateReviewDtoToReviewAdapter {
    public Review convertDto(CreateReviewDto createReviewDto);
}
