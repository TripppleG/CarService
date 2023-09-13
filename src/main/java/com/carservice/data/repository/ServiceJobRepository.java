package com.carservice.data.repository;

import com.carservice.data.entity.Customer;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.ServiceJobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Provider;
import java.time.LocalDate;
import java.util.List;

public interface ServiceJobRepository extends JpaRepository<ServiceJob, Long> {
//    List<ServiceJob> findAllByCustomerEmail(String customerEmail);
//
//    List<ServiceJob> findAllByCarLicensePlate(String carLicensePlate);

    List<ServiceJob> findAllByEmployeeEmail(String employeeEmail);

    List<ServiceJob> findAllByType(ServiceJobType type);

    List<ServiceJob> findAllByDateStarted(LocalDate dateStarted);

    List<ServiceJob> findAllByDateStartedIsNull();

    List<ServiceJob> findAllByDateFinished(LocalDate dateFinished);

//    List<ServiceJob> findAllByCarLicensePlateAndDateFinished(String carLicensePlate, LocalDate dateFinished);
//
//    List<ServiceJob> findAllByCarLicensePlateAndDateStarted(String carLicensePlate, LocalDate dateStarted);

    List<ServiceJob> findAllByPriceLessThanEqual(double price);

    List<ServiceJob> findAllByPriceGreaterThanEqual(double price);
}
