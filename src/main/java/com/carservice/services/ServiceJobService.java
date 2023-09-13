package com.carservice.services;

import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.ServiceJobType;
import com.carservice.dto.ServiceJobDTO;

import java.time.LocalDate;
import java.util.List;

public interface ServiceJobService {
    List<ServiceJobDTO> getServiceJobs();

    ServiceJobDTO getServiceJob(Long id);

    ServiceJob create(ServiceJobDTO serviceJobDTO);

    ServiceJob updateServiceJob(Long id, ServiceJobDTO serviceJobDTO);

    void deleteServiceJob(Long id);

//    List<ServiceJobDTO> getServiceJobsByCustomerEmail(String customerEmail);
//
//    List<ServiceJobDTO> getServiceJobsByCarLicensePlate(String carLicensePlate);

    List<ServiceJobDTO> getServiceJobsByEmployeeEmail(String employeeEmail);

    List<ServiceJobDTO> getServiceJobsByType(ServiceJobType type);

    List<ServiceJobDTO> getServiceJobsByDateStarted(LocalDate dateStarted);

    List<ServiceJobDTO> getServiceJobsByDateStartedIsNull();

    List<ServiceJobDTO> getServiceJobsByDateFinished(LocalDate dateFinished);

//    List<ServiceJobDTO> getServiceJobsByCarLicensePlateAndDateFinished(String carLicensePlate, LocalDate dateFinished);
//
//    List<ServiceJobDTO> getServiceJobsByCarLicensePlateAndDateStarted(String carLicensePlate, LocalDate dateStarted);

    List<ServiceJobDTO> getServiceJobsByPriceLessThanEqual(double price);

    List<ServiceJobDTO> getServiceJobsByPriceGreaterThanEqual(double price);
}
