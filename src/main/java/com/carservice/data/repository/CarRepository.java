package com.carservice.data.repository;

import com.carservice.data.entity.Car;
import com.carservice.data.enums.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {
    List<Car> findAllByBrand(CarBrand carBrand);
    @Override
    List<Car> findAll();
}
