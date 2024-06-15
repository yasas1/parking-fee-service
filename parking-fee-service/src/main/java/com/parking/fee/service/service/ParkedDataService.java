package com.parking.fee.service.service;

import com.parking.fee.service.domain.ParkedData;
import com.parking.fee.service.domain.ParkingCity;

import java.time.LocalDate;
import java.util.List;

public interface ParkedDataService {
    List<ParkedData> findAllParkedDataByCityAndVehicleAndDate(ParkingCity city, String vehicleNumber, LocalDate startDate, LocalDate endDate);
}
