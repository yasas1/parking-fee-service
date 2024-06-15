package com.parking.fee.service.service.impl;

import com.parking.fee.service.domain.ParkingCity;
import com.parking.fee.service.domain.WeekdayParkingFeeRule;
import com.parking.fee.service.repository.WeekdayParkingFeeRuleRepository;
import com.parking.fee.service.service.WeekdayParkingFeeRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Service
public class WeekdayParkingFeeRuleServiceImpl implements WeekdayParkingFeeRuleService {
    private final WeekdayParkingFeeRuleRepository weekdayParkingFeeRuleRepository;
    private final Map<ParkingCity, List<WeekdayParkingFeeRule>> weekdayParkingFeeRuleMap = new ConcurrentHashMap<>();

    @Override
    public List<WeekdayParkingFeeRule> findAllByCity(ParkingCity city) {
        return weekdayParkingFeeRuleMap.computeIfAbsent(city, weekdayParkingFeeRuleRepository::findAllByCity);
    }
}
