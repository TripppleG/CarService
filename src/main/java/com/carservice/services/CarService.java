package com.carservice.services;

import com.carservice.data.entity.Car;
import com.carservice.data.enums.CarBrand;
import com.carservice.dto.CarDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

public interface CarService {
    List<CarDTO> getCars();

    CarDTO getCar(String licensePlate);

    Car create(@Valid CarDTO carDTO);

    Car updateCar(String licensePlate, @Valid CarDTO carDTO);

    void deleteCar(String id);

    List<CarDTO> getCarsByBrand(CarBrand brand);

    List<CarDTO> getCarsByModelStartingWith(String model, Sort sort);

    CarDTO getCarByYear(LocalDate year);

    List<CarDTO> getCarsByYear(LocalDate year);

    List<CarDTO> getCarsByOwnerEmail(String ownerEmail);

    List<CarDTO> getCarsByOwnerPhoneNumber(String ownerPhoneNumber);

    List<CarDTO> getCarsByBrandAndModel(CarBrand brand, String model);

    List<CarDTO> getCarsByBrandAndYear(CarBrand brand, LocalDate year);

    List<CarDTO> getCarsByModelAndYear(String model, LocalDate year);

    List<CarDTO> getCarsByBrandAndModelAndYear(CarBrand brand, String model, LocalDate year);
}
