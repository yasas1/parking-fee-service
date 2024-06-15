package com.parking.fee.service.service;

import com.parking.fee.service.domain.ParkingCity;
import com.parking.fee.service.domain.WeekdayParkingFeeRule;

import java.util.List;

public interface WeekdayParkingFeeRuleService {
    List<WeekdayParkingFeeRule> findAllByCity(ParkingCity city);
}
