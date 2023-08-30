package com.carservice.services;

import com.carservice.data.entity.Appointment;
import com.carservice.data.entity.CarCenter;
import com.carservice.data.enums.CarBrand;
import com.carservice.dto.AppointmentDTO;
import com.carservice.dto.CarCenterDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CarCenterService {
    List<CarCenterDTO> getCarCenters();

    CarCenterDTO getCarCenter(@Min(1) Long id);

    CarCenter create(@Valid CarCenterDTO carCenterDTO);

    CarCenter updateCarCenter(Long id, @Valid CarCenterDTO carCenterDTO);

    void deleteCarCenter(Long id);

    List<CarCenterDTO> getCarCentersByName(String name);

    List<CarCenterDTO> getCarCentersByNameStartingWith(String carCenterName, Sort sort);

    List<CarCenterDTO> getCarCentersByWorkWithBrand(CarBrand brand);

    List<CarCenterDTO> getCarCentersByWorkWithBrandStartingWith(CarBrand brand, String name);


}
