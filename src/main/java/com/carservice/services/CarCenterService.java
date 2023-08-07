package com.carservice.services;

import com.carservice.data.entity.Appointment;
import com.carservice.data.entity.CarCenter;
import com.carservice.data.enums.CarBrand;
import com.carservice.dto.AppointmentDTO;
import com.carservice.dto.CarCenterDTO;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CarCenterService {
    List<CarCenterDTO> getCarCenters();
    CarCenterDTO getCarCenter(Long id);
    CarCenter create(CarCenter carCenter);
    CarCenter updateCarCenter(Long id, CarCenterDTO appointmentDTO);
    void deleteCarCenter(Long id);


    List<CarCenterDTO> getCarCentersByName(String name);

    List<CarCenterDTO> getCarCentersByNameStartingWith(String carCenterName, Sort sort);

    List<CarCenterDTO> getCarCentersByWorkWithBrand(CarBrand brand);

    List<CarCenterDTO> getCarCentersByWorkWithBrandAndName(CarBrand brand, String name);

    List<CarCenterDTO> getCarCentersByWorkWithBrandStartingWith(CarBrand brand, String name);
}
