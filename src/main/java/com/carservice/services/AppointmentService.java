package com.carservice.services;

import com.carservice.data.entity.Appointment;
import java.util.List;

public interface AppointmentService {
    List<Appointment> getAppointments();
    Appointment getAppointment(Long id);
    Appointment create(Appointment appointment);
    Appointment updateAppointment(Long id, Appointment appointment);
    void deleteAppointment(Long id);
    List<Appointment> getAppointmentsByDateCreated(String dateCreated);
    List<Appointment> getAppointmentsByCustomer(Long customerId);
    List<Appointment> getAppointmentsByServiceCenter(Long serviceCenterId);
    List<Appointment>
}
