package com.parking.fee.service.repository;

import com.parking.fee.service.domain.ParkedData;
import com.parking.fee.service.domain.ParkingCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ParkedDataRepository extends JpaRepository<ParkedData, Long> {
    List<ParkedData> findByCityIdAndVehicleNumberAndDateBetween(Long cityId, String vehicleNumber, LocalDate date, LocalDate date2);
    List<ParkedData> findAllByCityAndVehicleNumberAndDateBetween(ParkingCity city, String vehicleNumber, LocalDate date, LocalDate date2);
}
