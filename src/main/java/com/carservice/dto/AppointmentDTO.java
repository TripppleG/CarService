package com.carservice.dto;

import com.carservice.data.entity.Car;
import com.carservice.data.entity.Customer;
import com.carservice.data.entity.CarCenter;
import com.carservice.data.entity.ServiceJob;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AppointmentDTO {
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "The customer must be set!")
    private Customer customer;

    @NotNull(message = "The car center must be set!")
    private CarCenter carCenter;

    @NotNull(message = "The car must be set!")
    private Car car;

    @NotNull(message = "The date created must be set!")
    @PastOrPresent(message = "The date created must not be the future!")
    private LocalDate dateCreated;

    @NotNull(message = "The date of appointment must be set!")
    @Future(message = "The date of appointment must be in the future!")
    private LocalDate dateOfAppointment;

    @NotNull(message = "The is past must be set!")
    private Boolean isPast = false;
}