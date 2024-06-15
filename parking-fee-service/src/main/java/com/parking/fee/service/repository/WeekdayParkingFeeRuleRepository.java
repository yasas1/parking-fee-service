package com.parking.fee.service.repository;

import com.parking.fee.service.domain.ParkingCity;
import com.parking.fee.service.domain.WeekdayParkingFeeRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeekdayParkingFeeRuleRepository extends JpaRepository<WeekdayParkingFeeRule, Long> {
    List<WeekdayParkingFeeRule> findAllByCity(ParkingCity city);
}
