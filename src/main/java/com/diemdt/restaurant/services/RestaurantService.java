package com.diemdt.restaurant.services;

import com.diemdt.restaurant.domain.RestaurantCreateUpdateRequest;
import com.diemdt.restaurant.domain.entities.Restaurant;

public interface RestaurantService {
    Restaurant createRestaurant(RestaurantCreateUpdateRequest request);
}
