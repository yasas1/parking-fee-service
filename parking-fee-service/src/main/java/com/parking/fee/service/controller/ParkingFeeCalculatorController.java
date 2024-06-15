package com.parking.fee.service.controller;

import com.parking.fee.service.domain.response.ParkingFeeResponse;
import com.parking.fee.service.service.ParkingFeeCalculatorService;
import com.parking.fee.service.type.VehicleType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@AllArgsConstructor
@RestController
@RequestMapping(path = "parking-fee-service/calculation")
public class ParkingFeeCalculatorController {

    private final ParkingFeeCalculatorService parkingFeeCalculatorService;

    @GetMapping(path = "/city/{cityId}/vehicle/{vehicleNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParkingFeeResponse> calculateParkingFee(@PathVariable Long cityId,
                                                                  @PathVariable String vehicleNumber,
                                                                  @RequestParam VehicleType vehicleType,
                                                                  @RequestParam LocalDate startDate,
                                                                  @RequestParam LocalDate endDate) {
        if (startDate.equals(endDate) || startDate.isAfter(endDate)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Start date cannot be same or after end date");
        }
        return new ResponseEntity<>(
                this.parkingFeeCalculatorService.calculateParkingFee(cityId, vehicleNumber, vehicleType, startDate, endDate),
                HttpStatus.OK
        );
    }
}
