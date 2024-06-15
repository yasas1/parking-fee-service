package com.parking.fee.service.service;

import com.parking.fee.service.domain.VehicleMonthlySubscription;

import java.util.Optional;

public interface VehicleMonthlySubscriptionService {
    Optional<VehicleMonthlySubscription> findByVehicleNumber(String vehicleNumber);
}
