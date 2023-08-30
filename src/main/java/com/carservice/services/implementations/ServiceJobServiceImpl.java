package com.carservice.services.implementations;

import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.ServiceJobType;
import com.carservice.data.repository.ServiceJobRepository;
import com.carservice.dto.ServiceJobDTO;
import com.carservice.exceptions.ServiceJobNotFoundException;
import com.carservice.services.ServiceJobService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
@Validated
public class ServiceJobServiceImpl implements ServiceJobService {
    private final ServiceJobRepository serviceJobRepository;
    private final ModelMapper modelMapper;

    private ServiceJobDTO convertToServiceJobDTO(ServiceJob serviceJob) {
        return modelMapper.map(serviceJob, ServiceJobDTO.class);
    }

    @Override
    public List<ServiceJobDTO> getServiceJobs() {
        return serviceJobRepository.findAll().stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public ServiceJobDTO getServiceJob(Long id) {
        return modelMapper.map(serviceJobRepository.findById(id)
                .orElseThrow(() -> new ServiceJobNotFoundException("ServiceJob with id " + id + " not found")), ServiceJobDTO.class);
    }

    @Override
    public ServiceJob create(ServiceJobDTO serviceJobDTO) {
        return serviceJobRepository.save(modelMapper.map(serviceJobDTO, ServiceJob.class));
    }

    @Override
    public ServiceJob updateServiceJob(Long id, ServiceJobDTO serviceJobDTO) {
        ServiceJob serviceJob = modelMapper.map(serviceJobDTO, ServiceJob.class);
        serviceJob.setId(id);
        return serviceJobRepository.save(serviceJob);
    }

    @Override
    public void deleteServiceJob(Long id) {
        serviceJobRepository.deleteById(id);
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByCustomerEmail(String customerEmail) {
        return serviceJobRepository.findAllByCustomerEmail(customerEmail).stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByCarLicensePlate(String carLicensePlate) {
        return serviceJobRepository.findAllByCarLicensePlate(carLicensePlate).stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByEmployeeEmail(String employeeEmail) {
        return serviceJobRepository.findAllByEmployeeEmail(employeeEmail).stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByType(ServiceJobType type) {
        return serviceJobRepository.findAllByType(type).stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByDateStarted(LocalDate dateStarted) {
        return serviceJobRepository.findAllByDateStarted(dateStarted).stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByDateStartedIsNull() {
        return serviceJobRepository.findAllByDateStartedIsNull().stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByDateFinished(LocalDate dateFinished) {
        return serviceJobRepository.findAllByDateFinished(dateFinished).stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByCarLicensePlateAndDateFinished(String carLicensePlate, LocalDate dateFinished) {
        return serviceJobRepository.findAllByCarLicensePlateAndDateFinished(carLicensePlate, dateFinished).stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByCarLicensePlateAndDateStarted(String carLicensePlate, LocalDate dateStarted) {
        return serviceJobRepository.findAllByCarLicensePlateAndDateStarted(carLicensePlate, dateStarted).stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByPriceLessThanEqual(double price) {
        return serviceJobRepository.findAllByPriceLessThanEqual(price).stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ServiceJobDTO> getServiceJobsByPriceGreaterThanEqual(double price) {
        return serviceJobRepository.findAllByPriceGreaterThanEqual(price).stream()
                .map(this::convertToServiceJobDTO)
                .collect(java.util.stream.Collectors.toList());
    }
}
