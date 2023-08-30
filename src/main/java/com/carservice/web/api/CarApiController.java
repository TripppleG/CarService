package com.carservice.web.api;

import com.carservice.dto.CarDTO;
import com.carservice.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-{customerId}/cars")
@AllArgsConstructor
public class CarApiController {
    private final CarService carService;

    @GetMapping("/")
    public List<CarDTO> getCars() { return carService.getCars(); }

    @GetMapping("/{licensePlate}")
    public CarDTO getCar(@RequestParam @PathVariable("licensePlate") String licensePlate) { return carService.getCar(licensePlate); }
}
