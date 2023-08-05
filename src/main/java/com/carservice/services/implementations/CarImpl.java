package com.carservice.services.implementations;

import com.carservice.data.entity.Car;
import com.carservice.data.repository.CarRepository;
import com.carservice.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarImpl implements CarService {
    private final CarRepository carRepository;

}
