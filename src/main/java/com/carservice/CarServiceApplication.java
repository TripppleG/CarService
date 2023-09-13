package com.carservice;

import com.carservice.data.entity.*;
import com.carservice.data.enums.CarBrand;
import com.carservice.data.enums.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CarServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
//        CarCenter carCenter = new CarCenter(1L, "CarCenter", CarBrand.ALL, null, new HashSet<>(), null, null);
//        HashSet<CarCenter> carCenters = new HashSet<>();
//        carCenters.add(carCenter);
//        Employee employee = new Employee("a", "aa", "string", "Gope@2937", null, carCenter);
//        System.out.println(employee);
    }
}
