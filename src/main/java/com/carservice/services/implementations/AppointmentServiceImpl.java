package com.carservice.services.implementations;

import com.carservice.data.entity.Appointment;
import com.carservice.data.repository.AppointmentRepository;
import com.carservice.dto.AppointmentDTO;
import com.carservice.exceptions.AppointmentNotFoundException;
import com.carservice.services.AppointmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;

    private AppointmentDTO convertToAppointmentDTO(Appointment appointment) {
        return modelMapper.map(appointment, AppointmentDTO.class);
    }

    @Override
    public List<AppointmentDTO> getAppointments() {
        return appointmentRepository.findAll().stream()
                .map(this::convertToAppointmentDTO).
                collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO getAppointment(@Min(1) Long id) {
        return modelMapper.map(appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with id " + id + " not found")), AppointmentDTO.class);
    }

    @Override
    public Appointment create(@Valid AppointmentDTO appointmentDTO) {
        return appointmentRepository.save(modelMapper.map(appointmentDTO, Appointment.class));
    }

    @Override
    public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);
        appointment.setId(id);
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByCustomerEmail(String customerEmail) {
        return appointmentRepository.findAllByCustomerEmail(customerEmail).stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByDateCreated(LocalDate dateCreated) {
        return appointmentRepository.findAllByDateCreated(dateCreated).stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByDateOfAppointment(LocalDate dateOfAppointment) {
        return appointmentRepository.findAllByDateOfAppointment(dateOfAppointment).stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByCarCenterName(String carCenterName) {
        return appointmentRepository.findAllByCarCenterName(carCenterName).stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByCustomerFirstNameStartsWith(String customerName, Sort sort) {
        return appointmentRepository.findAllByCustomerFirstNameStartsWith(customerName, Sort.by("firstName")).stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByCustomerEmailAndDateOfAppointment(String customerEmail, LocalDate dateOfAppointment) {
        return appointmentRepository.findAllByCustomerEmailAndDateOfAppointment(customerEmail, dateOfAppointment).stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByCarCenterNameAndDateCreated(String carCenterName, LocalDate dateCreated) {
        return appointmentRepository.findAllByCarCenterNameAndDateCreated(carCenterName, dateCreated).stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByCarCenterNameAndDateOfAppointment(String carCenterName, LocalDate dateOfAppointment) {
        return appointmentRepository.findAllByCarCenterNameAndDateOfAppointment(carCenterName, dateOfAppointment).stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByHasPassedTrue() {
        return appointmentRepository.findAllByHasPassedTrue().stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }
}
