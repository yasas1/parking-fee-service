package com.parking.fee.service.service.impl;

import com.parking.fee.service.domain.VehicleMonthlySubscription;
import com.parking.fee.service.repository.VehicleMonthlySubscriptionRepository;
import com.parking.fee.service.service.VehicleMonthlySubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VehicleMonthlySubscriptionServiceImpl implements VehicleMonthlySubscriptionService {
    private final VehicleMonthlySubscriptionRepository repository;

    @Override
    public Optional<VehicleMonthlySubscription> findByVehicleNumber(String vehicleNumber) {
        return repository.findByVehicleNumber(vehicleNumber);
    }
}
