package com.parking.fee.service.service;

import com.parking.fee.service.domain.ParkingCity;

public interface ParkingCityService {
    ParkingCity getParkingCityById(Long id);
    ParkingCity getParkingCityByCityName(String cityName);
}
