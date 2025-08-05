package com.diemdt.restaurant.services;

import com.diemdt.restaurant.domain.GeoLocation;
import com.diemdt.restaurant.domain.entities.Address;

public interface GeoLocationService {
    GeoLocation geoLocate(Address address);
}
