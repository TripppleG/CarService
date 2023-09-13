package com.carservice.data.repository;

import com.carservice.data.entity.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByCustomerEmail(String customerEmail);

    List<Appointment> findAllByDateCreated(LocalDate dateCreated);

    List<Appointment> findAllByDateOfAppointment(LocalDate dateOfAppointment);

    List<Appointment> findAllByCarCenterName(String carCenter);

    List<Appointment> findAllByCustomerFirstNameStartsWith(String customerName, Sort sort);

    List<Appointment> findAllByCustomerEmailAndDateOfAppointment(String customerName, LocalDate dateOfAppointment);

    List<Appointment> findAllByCarCenterNameAndDateCreated(String carCenterName, LocalDate dateCreated);

    List<Appointment> findAllByCarCenterNameAndDateOfAppointment(String carCenterName, LocalDate dateOfAppointment);

    List<Appointment> findAllByHasPassedTrue();
}
