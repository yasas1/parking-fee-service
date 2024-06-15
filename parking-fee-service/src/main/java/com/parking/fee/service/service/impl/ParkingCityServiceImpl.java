package com.parking.fee.service.service.impl;

import com.parking.fee.service.domain.ParkingCity;
import com.parking.fee.service.repository.ParkingCityRepository;
import com.parking.fee.service.service.ParkingCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Service
public class ParkingCityServiceImpl implements ParkingCityService {
    private final ParkingCityRepository parkingCityRepository;
    private final Map<Long, ParkingCity> parkingCityMap = new ConcurrentHashMap<>();

    @Override
    public ParkingCity getParkingCityById(Long id) {
        return parkingCityMap.computeIfAbsent(id,
                i -> parkingCityRepository.findById(i)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parking city not found. Please contact the system administrator"))
        );
    }

    @Override
    public ParkingCity getParkingCityByCityName(String cityName) {
        return this.parkingCityRepository.findByName(cityName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parking city not found. Please contact the system administrator"));
    }
}
