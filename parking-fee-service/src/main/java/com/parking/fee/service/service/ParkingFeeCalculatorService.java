package com.parking.fee.service.service;

import com.parking.fee.service.domain.model.Vehicle;
import com.parking.fee.service.domain.response.ParkingFeeResponse;
import com.parking.fee.service.type.VehicleType;

import java.time.LocalDate;

public interface ParkingFeeCalculatorService {

    ParkingFeeResponse calculateParkingFee(Long cityId, String vehicleNumber, VehicleType vehicleType, LocalDate startDate, LocalDate endDate);
}
