package com.carservice.services.implementations;

import com.carservice.data.entity.CarCenter;
import com.carservice.data.enums.CarBrand;
import com.carservice.data.repository.AppointmentRepository;
import com.carservice.data.repository.CarCenterRepository;
import com.carservice.dto.CarCenterDTO;
import com.carservice.exceptions.CarCenterNotFoundException;
import com.carservice.services.CarCenterService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class CarCenterServiceImpl implements CarCenterService {
    private final CarCenterRepository carCenterRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CarCenterDTO> getCarCenters() {
        return carCenterRepository.findAll().stream()
                .map(this::convertToCarCenterDTO).
                collect(Collectors.toList());
    }

    @Override
    public CarCenterDTO getCarCenter(Long id) {
        return modelMapper.map(carCenterRepository.findById(id)
                .orElseThrow(() -> new CarCenterNotFoundException("Car center with id " + id + " not found")), CarCenterDTO.class);
    }

    @Override
    public CarCenter create(CarCenter carCenter) {
        return carCenterRepository.save(modelMapper.map(carCenter, CarCenter.class));
    }

    @Override
    public CarCenter updateCarCenter(Long id, CarCenterDTO carCenterDTO) {
        CarCenter carCenter = modelMapper.map(carCenterDTO, CarCenter.class);
        carCenter.setId(id);
        return carCenterRepository.save(carCenter);
    }

    @Override
    public void deleteCarCenter(Long id) {
        carCenterRepository.deleteById(id);
    }

    private CarCenterDTO convertToCarCenterDTO(CarCenter carCenter) {
        return modelMapper.map(carCenter, CarCenterDTO.class);
    }

    @Override
    public List<CarCenterDTO> getCarCentersByName(String name) {
        return carCenterRepository.findAllByName(name).stream()
                .map(this::convertToCarCenterDTO).
                collect(Collectors.toList());
    }

    @Override
    public List<CarCenterDTO> getCarCentersByNameStartingWith(String carCenterName, Sort sort){
        return carCenterRepository.findAllByNameStartingWith(carCenterName, Sort.by("name")).stream()
                .map(this::convertToCarCenterDTO).
                collect(Collectors.toList());
    }

    @Override
    public List<CarCenterDTO> getCarCentersByWorkWithBrand(CarBrand brand){
        return carCenterRepository.findAllByWorkWithBrand(brand).stream()
                .map(this::convertToCarCenterDTO).
                collect(Collectors.toList());
    }

    @Override
    public List<CarCenterDTO> getCarCentersByWorkWithBrandAndName(CarBrand brand, String name){
        return carCenterRepository.findAllByWorkWithBrandAndName(brand, name).stream()
                .map(this::convertToCarCenterDTO).
                collect(Collectors.toList());
    }

    @Override
    public List<CarCenterDTO> getCarCentersByWorkWithBrandStartingWith(CarBrand brand, String name){
        return carCenterRepository.findAllByWorkWithBrandStartingWith(brand, Sort.by("workWithBrand")).stream()
                .map(this::convertToCarCenterDTO).
                collect(Collectors.toList());
    }
}
