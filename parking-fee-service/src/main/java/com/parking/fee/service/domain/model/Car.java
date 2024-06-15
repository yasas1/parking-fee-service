package com.parking.fee.service.domain.model;

import com.parking.fee.service.type.VehicleType;

public class Car implements Vehicle {

    private final String vehicleNumber;
    private final VehicleType type;

    public Car(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = VehicleType.CAR;
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
