package com.parking.fee.service.domain.model;

import com.parking.fee.service.type.VehicleType;

public class ThreeWheel implements Vehicle {

    private final String vehicleNumber;
    private final VehicleType type;

    public ThreeWheel(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = VehicleType.THREE_WHEEL;
    }

    @Override
    public VehicleType getVehicleType() {
        return this.type;
    }

    @Override
    public String getVehicleNumber() {
        return this.vehicleNumber;
    }
}
