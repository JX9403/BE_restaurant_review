package com.diemdt.restaurant.controllers;

import com.diemdt.restaurant.domain.RestaurantCreateUpdateRequest;
import com.diemdt.restaurant.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.diemdt.restaurant.domain.dtos.RestaurantDto;
import com.diemdt.restaurant.domain.dtos.RestaurantSummaryDto;
import com.diemdt.restaurant.domain.entities.Restaurant;
import com.diemdt.restaurant.mappers.RestaurantMapper;
import com.diemdt.restaurant.services.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(
            @Valid @RequestBody RestaurantCreateUpdateRequestDto request
    ) {
        RestaurantCreateUpdateRequest restaurantCreateUpdateRequest = restaurantMapper
                .toRestaurantCreateUpdateRequest(request);

        Restaurant restaurant = restaurantService.createRestaurant(restaurantCreateUpdateRequest);
        RestaurantDto createdRestaurantDto = restaurantMapper.toRestaurantDto(restaurant);
        return ResponseEntity.ok(createdRestaurantDto);
    }

    @GetMapping
    public Page<RestaurantSummaryDto> searchRestaurants(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) Float minRating,
            @RequestParam(required = false) Float latitude,
            @RequestParam(required = false) Float longitude,
            @RequestParam(required = false) Float radius,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size
    ){
        Page<Restaurant> searchResults = restaurantService.searchRestaurants(
                q, minRating, latitude, longitude, radius, PageRequest.of(page - 1, size)
        );

        return searchResults.map(restaurantMapper::toSummaryDto);
    }

}
