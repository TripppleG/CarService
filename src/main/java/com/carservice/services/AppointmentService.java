package com.carservice.services;

import com.carservice.data.entity.Appointment;
import com.carservice.dto.AppointmentDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> getAppointments();

    AppointmentDTO getAppointment(@Min(1) Long id);

    Appointment create(@Valid AppointmentDTO appointment);

    Appointment updateAppointment(Long id, @Valid AppointmentDTO appointmentDTO);

    void deleteAppointment(Long id);

    List<AppointmentDTO> getAppointmentsByCustomerEmail(String customerEmail);

    List<AppointmentDTO> getAppointmentsByDateCreated(LocalDate dateCreated);

    List<AppointmentDTO> getAppointmentsByDateOfAppointment(LocalDate dateOfAppointment);

    List<AppointmentDTO> getAppointmentsByCarCenterName(String carCenterName);

    List<AppointmentDTO> getAppointmentsByCustomerFirstNameStartsWith(String customerName, Sort sort);

    List<AppointmentDTO> getAppointmentsByCustomerEmailAndDateOfAppointment(String customerEmail, LocalDate dateOfAppointment);

    List<AppointmentDTO> getAppointmentsByCarCenterNameAndDateCreated(String carCenterName, LocalDate dateCreated);

    List<AppointmentDTO> getAppointmentsByCarCenterNameAndDateOfAppointment(String carCenterName, LocalDate dateOfAppointment);

    List<AppointmentDTO> getAppointmentsByIsPastTrue();
}
