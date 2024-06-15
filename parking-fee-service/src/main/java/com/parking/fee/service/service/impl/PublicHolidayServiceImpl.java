package com.parking.fee.service.service.impl;

import com.parking.fee.service.domain.PublicHoliday;
import com.parking.fee.service.repository.PublicHolidayRepository;
import com.parking.fee.service.service.PublicHolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Service
public class PublicHolidayServiceImpl implements PublicHolidayService {
    private final PublicHolidayRepository publicHolidayRepository;
    private final Map<Integer, List<PublicHoliday>> publicHolidayMap = new ConcurrentHashMap<>();

    @Override
    public List<PublicHoliday> getPublicHolidaysByYear(int year) {
        return publicHolidayMap.computeIfAbsent(year, publicHolidayRepository::findByYear);
    }
}
