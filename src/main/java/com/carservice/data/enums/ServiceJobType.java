package com.carservice.data.enums;

import lombok.Getter;

@Getter
public enum ServiceJobType {
    BODY_REPAIR("Body Repair"),
    BRAKE_SYSTEM("Brake System"),
    DIAGNOSTICS("Diagnostics"),
    ELECTRIC_SYSTEM("Electric System"),
    ENGINE("Engine"),
    EXHAUST_SYSTEM("Exhaust System"),
    FILTER_CHANGE("Filter Change"),
    FUEL_SYSTEM("Fuel System"),
    GENERAL("General"),
    IGNITION_SYSTEM("Ignition System"),
    OIL_CHANGE("Oil Change"),
    PAINT_JOB("Paint Job"),
    STARTING_SYSTEM("Starting System"),
    SUSPENSION("Suspension");

    private final String serviceJobType;

    ServiceJobType(String serviceJobType) {
        this.serviceJobType = serviceJobType;
    }

}
