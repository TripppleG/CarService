package com.carservice.data.repository;

import com.carservice.data.entity.Customer;
import com.carservice.data.entity.Employee;
import org.springframework.data.geo.CustomMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByEmail(String email);

    List<Customer> findAllByFirstName(String firstName);

    List<Customer> findAllByLastName(String lastName);

    List<Customer> findAllByPhoneNumber(String phoneNumber);

    @Query("SELECT c FROM Customer c JOIN c.cars car WHERE car.licensePlate = ?1")
    Customer findByCarLicensePlate(String carLicensePlate);

    @Query("SELECT c FROM Customer c JOIN c.appointments appointment WHERE appointment.id = ?1")
    Customer findByAppointmentId(Long appointmentId);
}
