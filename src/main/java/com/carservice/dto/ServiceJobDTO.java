package com.carservice.dto;

import com.carservice.data.entity.Appointment;
import com.carservice.data.entity.Car;
import com.carservice.data.entity.Customer;
import com.carservice.data.entity.Employee;
import com.carservice.data.enums.ServiceJobStatus;
import com.carservice.data.enums.ServiceJobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ServiceJobDTO {
    private Long id;

    @NotNull(message = "The customer must be set!")
    private Customer customer;

    @NotNull(message = "The car must be set!")
    private Car car;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "The type must be set!")
    private ServiceJobType type;

    private LocalDate dateStarted;

    private LocalDate dateFinished;

    private Employee employee;

    private Double price;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "The status must be set!")
    private ServiceJobStatus status;
}