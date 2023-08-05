package com.carservice.data.repository;

import com.carservice.data.entity.Appointment;
import com.carservice.data.entity.Customer;
import com.carservice.data.entity.ServiceCenter;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByCustomer();
    List<Appointment> findAllByDateCreated();
    List<Appointment> findAllByDateOfAppointment();
    List<Appointment> findAllByServiceCenter();
    List<Appointment> findAllByCustomerAndDateCreated(Customer customer, LocalDate dateCreated);
    List<Appointment> findAllByCustomerAndDateOfAppointment(Customer customer, LocalDate dateOfAppointment);
    List<Appointment> findAllByCustomerAndServiceCenter(Customer customer, ServiceCenter serviceCenter);
    List<Appointment> findAllByDateCreatedAndDateOfAppointment(LocalDate dateCreated, LocalDate dateOfAppointment);
    List<Appointment> findAllByServiceCenterAndDateCreated(ServiceCenter serviceCenter, LocalDate dateCreated);
    List<Appointment> findAllByServiceCenterAndDateOfAppointment(ServiceCenter serviceCenter, LocalDate dateOfAppointment);
    List<Appointment> findAllByCustomerAndDateCreatedAndDateOfAppointment(Customer customer, LocalDate dateCreated, LocalDate dateOfAppointment);
    

}
