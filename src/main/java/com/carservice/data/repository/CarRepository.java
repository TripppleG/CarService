package com.carservice.data.repository;

import com.carservice.data.entity.Car;
import com.carservice.data.enums.CarBrand;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {
    List<Car> findAllByBrand(CarBrand carBrand);

    List<Car> findAllByModelStartingWith(String model, Sort sort);

    Car findByYear(LocalDate year);

    List<Car> findAllByYear(LocalDate year);

    List<Car> findAllByOwnerEmail(String ownerEmail);

    List<Car> findAllByOwnerPhoneNumber(String ownerPhoneNumber);

    List<Car> findAllByBrandAndModel(CarBrand brand, String model);

    List<Car> findAllByBrandAndYear(CarBrand brand, LocalDate year);

    List<Car> findAllByModelAndYear(String model, LocalDate year);

    List<Car> findAllByBrandAndModelAndYear(CarBrand brand, String model, LocalDate year);
}
