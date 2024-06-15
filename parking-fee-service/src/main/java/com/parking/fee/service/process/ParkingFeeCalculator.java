package com.parking.fee.service.process;

import com.parking.fee.service.domain.PublicHoliday;
import com.parking.fee.service.domain.WeekdayParkingFeeRule;
import com.parking.fee.service.domain.model.Vehicle;
import com.parking.fee.service.service.PublicHolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ParkingFeeCalculator {

    private final PublicHolidayService publicHolidayService;

    public double calculateParkingFee(List<WeekdayParkingFeeRule> weekdayParkingFeeRules, Vehicle vehicle, LocalDate date, LocalTime startTime, LocalTime endTime) {
        if (isPublicHoliday(date)) {
            return 0.0;
        }
        double totalFee = 0.0;
        while (startTime.isBefore(endTime)) {
            totalFee += getHourlyFee(startTime, weekdayParkingFeeRules);
            startTime = startTime.plusHours(1);
        }
        return totalFee;
    }

    public boolean isPublicHoliday(LocalDate date) {
        List<LocalDate> publicHolidaysByYear = this.publicHolidayService.getPublicHolidaysByYear(date.getYear())
                .stream().map(PublicHoliday::getDate).toList();
        return publicHolidaysByYear.contains(date);
    }

    private double getHourlyFee(LocalTime time, List<WeekdayParkingFeeRule> weekdayParkingFeeRules) {
        for (WeekdayParkingFeeRule rule : weekdayParkingFeeRules) {
            if ((time.equals(rule.getStartTime()) || time.isAfter(rule.getStartTime())) && time.isBefore(rule.getEndTime())) {
                return rule.getAmount();
            }
        }
        return 0.00;
    }

    public boolean isFeeExemptVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().isFeeExempt();
    }
}
