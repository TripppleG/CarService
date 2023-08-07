package com.carservice.dto;

import com.carservice.data.entity.Customer;
import com.carservice.data.entity.CarCenter;
import com.carservice.data.entity.ServiceJob;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AppointmentDTO {
    private Long id;
    private Customer customer;
    private LocalDate dateCreated;
    private LocalDate dateOfAppointment;
    private CarCenter carCenter;
    private Set<ServiceJob> serviceJobs;
}