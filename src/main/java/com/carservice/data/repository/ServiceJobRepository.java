package com.carservice.data.repository;

import com.carservice.data.entity.Customer;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.ServiceJobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceJobRepository extends JpaRepository<ServiceJob, Long> {
    List<ServiceJob> findAllByDateFinished(LocalDate dateFinished);

    List<ServiceJob> findAllByDateStarted(LocalDate dateStarted);

    List<ServiceJob> findAllByCustomer(Customer customer);

    List<ServiceJob> findAllByType(ServiceJobType type);


}
