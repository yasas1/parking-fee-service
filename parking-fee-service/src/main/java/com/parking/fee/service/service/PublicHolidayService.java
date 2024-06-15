package com.parking.fee.service.service;

import com.parking.fee.service.domain.PublicHoliday;

import java.util.List;

public interface PublicHolidayService {
    List<PublicHoliday> getPublicHolidaysByYear(int year);
}
