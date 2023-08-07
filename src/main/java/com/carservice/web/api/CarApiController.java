package com.carservice.web.api;

import com.carservice.data.entity.Car;
import com.carservice.dto.CarDTO;
import com.carservice.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/{customerId}/cars")
@AllArgsConstructor
public class CarApiController {
    private final CarService carService;

    @GetMapping("/")
    public List<CarDTO> getCars() { return carService.getCars(); }

    @GetMapping("/{id}")
    public CarDTO getCar(@PathVariable String licensePlate) { return carService.getCar(licensePlate); }
}
