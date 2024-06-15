package com.parking.fee.service.repository;

import com.parking.fee.service.domain.VehicleMonthlySubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleMonthlySubscriptionRepository extends JpaRepository<VehicleMonthlySubscription, Long> {
    Optional<VehicleMonthlySubscription> findByVehicleNumber(String vehicleNumber);
}
