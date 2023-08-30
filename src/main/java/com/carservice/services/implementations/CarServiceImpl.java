package com.carservice.services.implementations;

import com.carservice.data.entity.Car;
import com.carservice.data.enums.CarBrand;
import com.carservice.data.repository.CarRepository;
import com.carservice.dto.CarDTO;
import com.carservice.exceptions.CarNotFoundException;
import com.carservice.services.CarService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    private CarDTO convertToCarDTO(Car car) {
        return modelMapper.map(car, CarDTO.class);
    }

    @Override
    public List<CarDTO> getCars() {
        return carRepository.findAll().stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO getCar(String licensePlate) {
        return modelMapper.map(carRepository.findById(licensePlate)
                .orElseThrow(() -> new CarNotFoundException("Car with license plate " + licensePlate + " not found")), CarDTO.class);
    }

    @Override
    public Car create(CarDTO carDTO) {
        return carRepository.save(modelMapper.map(carDTO, Car.class));
    }

    @Override
    public Car updateCar(String licensePlate, CarDTO carDTO) {
        Car car = modelMapper.map(carDTO, Car.class);
        car.setLicensePlate(licensePlate);
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<CarDTO> getCarsByBrand(CarBrand brand) {
        return carRepository.findAllByBrand(brand).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByModelStartingWith(String model, Sort sort) {;
        return carRepository.findAllByModelStartingWith(model, Sort.by("model")).stream()
                .map(this::convertToCarDTO).
                collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarByYear(LocalDate year) {
        return modelMapper.map(carRepository.findByYear(year), CarDTO.class);
    }


    @Override
    public List<CarDTO> getCarsByYear(LocalDate year) {
        return carRepository.findAllByYear(year).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByOwnerEmail(String ownerEmail) {
        return carRepository.findAllByOwnerEmail(ownerEmail).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByOwnerPhoneNumber(String ownerPhoneNumber) {
        return carRepository.findAllByOwnerPhoneNumber(ownerPhoneNumber).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByBrandAndModel(CarBrand brand, String model) {
        return carRepository.findAllByBrandAndModel(brand, model).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByBrandAndYear(CarBrand brand, LocalDate year) {
        return carRepository.findAllByBrandAndYear(brand, year).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByModelAndYear(String model, LocalDate year) {
        return carRepository.findAllByModelAndYear(model, year).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByBrandAndModelAndYear(CarBrand brand, String model, LocalDate year) {
        return carRepository.findAllByBrandAndModelAndYear(brand, model, year).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }
}
