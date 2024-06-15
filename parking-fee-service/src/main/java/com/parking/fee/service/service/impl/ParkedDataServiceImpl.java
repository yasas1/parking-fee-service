package com.parking.fee.service.service.impl;

import com.parking.fee.service.domain.ParkedData;
import com.parking.fee.service.domain.ParkingCity;
import com.parking.fee.service.repository.ParkedDataRepository;
import com.parking.fee.service.service.ParkedDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ParkedDataServiceImpl implements ParkedDataService {
    private final ParkedDataRepository parkedDataRepository;

    @Override
    public List<ParkedData> findAllParkedDataByCityAndVehicleAndDate(ParkingCity city, String vehicleNumber, LocalDate startDate, LocalDate endDate) {
        return parkedDataRepository.findAllByCityAndVehicleNumberAndDateBetween(city, vehicleNumber, startDate, endDate);
    }
}
