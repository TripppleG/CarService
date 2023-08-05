package com.carservice.services;

import com.carservice.data.entity.Car;
import com.carservice.dto.CarDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    CarDTO getCar(@Min(1) Long id);
    Page<CarDTO> getCarsPagination(Pageable pageable);
    Car create(@Valid CarDTO car);
    Car updateCar(Long id, CarDTO car);
    void deleteCar(Long id);
}
