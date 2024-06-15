package com.parking.fee.service.domain.model;

import com.parking.fee.service.type.VehicleType;

public class Foreign implements Vehicle {

    private final String vehicleNumber;
    private final VehicleType type;

    public Foreign(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = VehicleType.FOREIGN;
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
