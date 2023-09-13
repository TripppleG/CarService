package com.carservice.web.api;

import com.carservice.data.entity.Car;
import com.carservice.data.enums.CarBrand;
import com.carservice.dto.CarDTO;
import com.carservice.services.CarService;
import com.carservice.web.view.model.CarViewModel;
import com.carservice.web.view.model.CreateCarViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarApiController {
    private final CarService carService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public List<CarDTO> getCars() {
        return carService.getCars();
    }

    @GetMapping("/{licensePlate}")
    public CarDTO getCar(@PathVariable("licensePlate") String licensePlate) {
        return carService.getCar(licensePlate);
    }

    @PostMapping
    public Car createCar(@RequestBody CreateCarViewModel car) {
        return carService.create(modelMapper.map(car, CarDTO.class));
    }

    @PutMapping("/{licensePlate}")
    public Car updateSchool(@PathVariable("licensePlate") String licensePlate, @RequestBody CarViewModel car) {
        return carService.updateCar(licensePlate, modelMapper.map(car, CarDTO.class));
    }

    @DeleteMapping("/{licensePlate}")
    public void deleteCar(@PathVariable("licensePlate") String licensePlate) {
        carService.deleteCar(licensePlate);
    }

    @GetMapping("/brand/{brand}")
    public List<CarDTO> getCarsByBrand(@PathVariable("brand") CarBrand brand) {
        return carService.getCarsByBrand(brand);
    }

    @GetMapping("/year/{year}")
    public CarDTO getCarByYear(@RequestParam("year") LocalDate year) {
        return carService.getCarByYear(year);
    }

    @GetMapping("/{year}")
    public List<CarDTO> getCarsByYear(@PathVariable("year") LocalDate year) {
        return carService.getCarsByYear(year);
    }

    @GetMapping("/owner-email/{ownerEmail}")
    public List<CarDTO> getCarsByOwnerEmail(@PathVariable("ownerEmail") String ownerEmail) {
        return carService.getCarsByOwnerEmail(ownerEmail);
    }

    @GetMapping("/owner-phone-number/{ownerPhoneNumber}")
    public List<CarDTO> getCarsByOwnerPhoneNumber(@PathVariable("ownerPhoneNumber") String ownerPhoneNumber) {
        return carService.getCarsByOwnerPhoneNumber(ownerPhoneNumber);
    }

    @GetMapping("/brand-model/{brand}-{model}")
    public List<CarDTO> getCarsByBrandAndModel(@PathVariable("brand") CarBrand brand, @PathVariable("model") String model) {
        return carService.getCarsByBrandAndModel(brand, model);
    }

    @GetMapping("/brand-year/{brand}-{year}")
    public List<CarDTO> getCarsByBrandAndYear(@PathVariable("brand") CarBrand brand, @PathVariable("year") LocalDate year) {
        return carService.getCarsByBrandAndYear(brand, year);
    }

    @GetMapping("/model-year/{model}-{year}")
    public List<CarDTO> getCarsByModelAndYear(@PathVariable("model") String model, @PathVariable("year") LocalDate year) {
        return carService.getCarsByModelAndYear(model, year);
    }

    @GetMapping("/brand-model-year/{brand}-{model}-{year}")
    public List<CarDTO> getCarsByBrandAndModelAndYear(@PathVariable("brand") CarBrand brand, @PathVariable("model") String model, @PathVariable("year") LocalDate year) {
        return carService.getCarsByBrandAndModelAndYear(brand, model, year);
    }

}
