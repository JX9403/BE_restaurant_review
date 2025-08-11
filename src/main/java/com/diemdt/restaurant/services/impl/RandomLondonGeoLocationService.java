package com.diemdt.restaurant.services.impl;

import com.diemdt.restaurant.domain.GeoLocation;
import com.diemdt.restaurant.domain.entities.Address;
import com.diemdt.restaurant.services.GeoLocationService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomLondonGeoLocationService implements GeoLocationService {

    private static final float MIN_LATITUDE = 20.95f;
    private static final float MAX_LATITUDE = 21.07f;
    private static final float MIN_LONGITUDE = 105.75f;
    private static final float MAX_LONGITUDE = 105.88f;


    @Override
    public GeoLocation geoLocate(Address address) {
        Random random = new Random();
        double latitude = MIN_LATITUDE + random.nextDouble() * (MAX_LATITUDE - MIN_LATITUDE);
        double longitude = MIN_LONGITUDE + random.nextDouble() * (MAX_LONGITUDE - MIN_LONGITUDE);

        return GeoLocation.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }

}
