package com.parking.fee.service.domain.model;

import com.parking.fee.service.type.VehicleType;

public interface Vehicle {
    VehicleType getVehicleType();
    String getVehicleNumber();
}
