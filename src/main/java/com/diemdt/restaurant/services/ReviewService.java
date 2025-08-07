package com.diemdt.restaurant.services;

import com.diemdt.restaurant.domain.ReviewCreateUpdateRequest;
import com.diemdt.restaurant.domain.entities.Review;
import com.diemdt.restaurant.domain.entities.User;

public interface ReviewService {
    Review createReview(User author, String restaurantId, ReviewCreateUpdateRequest review);
}
