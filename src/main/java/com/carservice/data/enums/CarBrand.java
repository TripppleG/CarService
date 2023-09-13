package com.carservice.data.enums;

import lombok.Getter;

@Getter
public enum CarBrand {
    ALL("All"),
    ACURA("Acura"),
    ASTON_MARTIN("Aston Martin"),
    AUDI("Audi"),
    BMW("BMW"),
    BUGATTI("Bugatti"),
    CHEVROLET("Chevrolet"),
    FERRARI("Ferrari"),
    FORD("Ford"),
    HONDA("Honda"),
    HYUNDAI("Hyundai"),
    INFINITI("Infiniti"),
    JAGUAR("Jaguar"),
    KIA("Kia"),
    LAND_ROVER("Land Rover"),
    LEXUS("Lexus"),
    LAMBORGHINI("Lamborghini"),
    MAZDA("Mazda"),
    McLAREN("McLaren"),
    MERCEDES_BENZ("Mercedes-Benz"),
    NISSAN("Nissan"),
    PORSCHE("Porsche"),
    SUBARU("Subaru"),
    TESLA("Tesla"),
    TOYOTA("Toyota"),
    VOLKSWAGEN("VW");

    private final String carBrand;

    CarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
}
