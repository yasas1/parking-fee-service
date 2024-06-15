package com.parking.fee.service.service.impl;

import com.parking.fee.service.domain.ParkedData;
import com.parking.fee.service.domain.ParkingCity;
import com.parking.fee.service.domain.VehicleMonthlySubscription;
import com.parking.fee.service.domain.WeekdayParkingFeeRule;
import com.parking.fee.service.domain.model.Vehicle;
import com.parking.fee.service.domain.response.ParkingFeeResponse;
import com.parking.fee.service.process.ParkingFeeCalculator;
import com.parking.fee.service.service.*;
import com.parking.fee.service.type.VehicleType;
import com.parking.fee.service.util.VehicleUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@RequiredArgsConstructor
@Service
public class ParkingFeeCalculatorServiceImpl implements ParkingFeeCalculatorService {

    private final ParkingCityService parkingCityService;
    private final WeekdayParkingFeeRuleService weekdayParkingFeeRuleService;
    private final ParkedDataService parkedDataService;
    private final ParkingFeeCalculator parkingFeeCalculator;
    private final VehicleMonthlySubscriptionService vehicleMonthlySubscriptionService;

    @Override
    public ParkingFeeResponse calculateParkingFee(Long cityId, String vehicleNumber, VehicleType vehicleType, LocalDate startDate, LocalDate endDate) {
        ParkingFeeResponse response = new ParkingFeeResponse();
        response.setStartDate(startDate);
        response.setEndDate(endDate);

        // Fee Exempt Vehicle
        Vehicle vehicle = VehicleUtil.createVehicle(vehicleNumber, vehicleType);
        if (parkingFeeCalculator.isFeeExemptVehicle(vehicle)) {
            response.setTotalFee(0.0);
            return response;
        }
        // Monthly Subscribed Vehicle
        Optional<VehicleMonthlySubscription> subscribedVehicle = vehicleMonthlySubscriptionService.findByVehicleNumber(vehicleNumber);
        if (subscribedVehicle.isPresent()) {
            Period diff = Period.between(startDate, endDate);
            double monthlySubscriptionFee = vehicle.getVehicleType().getMonthlySubscriptionFee();
            double fee = diff.getMonths() > 0 ? monthlySubscriptionFee * diff.getMonths() : monthlySubscriptionFee;
            response.setTotalFee(fee);
            return response;
        }
        // Calculation for parking
        ParkingCity city = parkingCityService.getParkingCityById(cityId);
        List<WeekdayParkingFeeRule> weekdayParkingFeeRules = weekdayParkingFeeRuleService.findAllByCity(city);
        if (weekdayParkingFeeRules.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Parking city rules are not configured. Please contact the system administrator");
        }
        List<ParkedData> parkedDataList = parkedDataService.findAllParkedDataByCityAndVehicleAndDate(city, vehicle.getVehicleNumber(), startDate, endDate);
        if (parkedDataList.isEmpty()) {
            response.setTotalFee(0.0);
            return response;
        }
        getParkingFeeForParkedData(parkedDataList, weekdayParkingFeeRules, vehicle, response);

        return response;
    }

    private void getParkingFeeForParkedData(List<ParkedData> parkedDataList, List<WeekdayParkingFeeRule> weekdayParkingFeeRules, Vehicle vehicle, ParkingFeeResponse response) {
        Map<LocalDate, Double> summary = new LinkedHashMap<>();
        double totalFee = 0.0;
        for (ParkedData parkedData : parkedDataList) {
            LocalDate date = parkedData.getDate();
            double fee = parkingFeeCalculator.calculateParkingFee(weekdayParkingFeeRules, vehicle, date, parkedData.getStartTime(), parkedData.getEndTime());
            if (summary.containsKey(date)) {
                summary.put(date, summary.get(date) + fee);
            } else {
                summary.put(date, fee);
            }
            totalFee += fee;
        }
        response.setTotalFee(totalFee);
        response.setSummary(summary);
    }
}
