package com.carservice.services.implementations;

import com.carservice.data.entity.Car;
import com.carservice.data.repository.CarRepository;
import com.carservice.dto.CarDTO;
import com.carservice.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<CarDTO> getCars() {
        return null;
    }

    @Override
    public CarDTO getCar(String licensePlate) {
        return null;
    }

    @Override
    public Car create(CarDTO car) {
        return null;
    }

    @Override
    public Car updateCar(Long id, CarDTO car) {
        return null;
    }

    @Override
    public void deleteCar(Long id) {

    }
}
