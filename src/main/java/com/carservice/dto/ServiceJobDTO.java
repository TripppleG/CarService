package com.carservice.dto;

import com.carservice.data.entity.Appointment;
import com.carservice.data.entity.Car;
import com.carservice.data.entity.Customer;
import com.carservice.data.entity.Employee;
import com.carservice.data.enums.ServiceJobStatus;
import com.carservice.data.enums.ServiceJobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ServiceJobDTO {
    private Long id;

    private Employee employee;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "The type must be set!")
    private ServiceJobType type;

    private LocalDate dateStarted;

    private LocalDate dateFinished;

    @Column(name = "price")
    @PositiveOrZero(message = "The price can't be negative")
    private Double price;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "The status must be set!")
    private ServiceJobStatus status = ServiceJobStatus.NEW;

    @ManyToOne(targetEntity = Appointment.class)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}