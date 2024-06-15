package com.parking.fee.service.repository;

import com.parking.fee.service.domain.ParkingCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingCityRepository extends JpaRepository<ParkingCity, Long> {
    Optional<ParkingCity> findByName(String name);
}
