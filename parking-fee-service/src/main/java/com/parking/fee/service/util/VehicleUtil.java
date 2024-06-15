package com.parking.fee.service.util;

import com.parking.fee.service.domain.model.*;
import com.parking.fee.service.type.VehicleType;

public class VehicleUtil {

    private VehicleUtil() {
    }

    public static Vehicle createVehicle(String vehicleNumber, VehicleType vehicleType) {
        return switch (vehicleType) {
            case CAR -> new Car(vehicleNumber);
            case VAN -> new Van(vehicleNumber);
            case LORRY -> new Lorry(vehicleNumber);
            case TRUCK -> new Truck(vehicleNumber);
            case MOTORBIKE -> new Motorbike(vehicleNumber);
            case THREE_WHEEL -> new ThreeWheel(vehicleNumber);
            case EMERGENCY -> new Emergency(vehicleNumber);
            case FOREIGN -> new Foreign(vehicleNumber);
            case GOVERNMENT -> new Government(vehicleNumber);
            default -> throw new IllegalStateException("Unexpected value: " + vehicleType);
        };

    }
}
