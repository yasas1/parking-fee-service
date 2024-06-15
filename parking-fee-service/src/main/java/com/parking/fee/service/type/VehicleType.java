package com.parking.fee.service.type;

import lombok.Getter;

@Getter
public enum VehicleType {
    CAR("Car", false, 5000.00),
    VAN("Van", false, 5000.00),
    LORRY("Lorry", false, 6000.00),
    TRUCK("Truck", false, 6000.00),
    MOTORBIKE("Motorbike", false, 4500.00),
    THREE_WHEEL("ThreeWheel", false, 4500.00),
    EMERGENCY("Emergency", true, 0),
    FOREIGN("Foreign", true, 0),
    GOVERNMENT("Government", true, 0);
    private final String name;
    private final boolean isFeeExempt;
    private final double monthlySubscriptionFee;

    VehicleType(String name, boolean isFeeExempt, double monthlySubscriptionFee) {
        this.name = name;
        this.monthlySubscriptionFee = monthlySubscriptionFee;
        this.isFeeExempt = isFeeExempt;
    }

    public static VehicleType fromName(String name) {
        for (VehicleType vehicleType : VehicleType.values()) {
            if (vehicleType.name.equalsIgnoreCase(name)) {
                return vehicleType;
            }
        }
        return null;
    }
}
