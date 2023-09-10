package com.carservice.web.view.model;

import com.carservice.data.entity.Car;
import com.carservice.data.entity.CarCenter;
import com.carservice.data.entity.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jdk.jfr.BooleanFlag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentViewModel {
    @NotNull(message = "The id must be set")
    @Positive(message = "The id must be positive")
    private Long id;

    @NotNull(message = "The customer must be set!")
    private Customer customer;

    @NotNull(message = "The car center must be set!")
    private CarCenter carCenter;

    @NotNull(message = "The car must be set!")
    private Car car;

    @NotNull(message = "The date created must be set!")
    private final LocalDate dateCreated = LocalDate.now();

    @NotNull(message = "The date of appointment must be set!")
    @Future(message = "The date of appointment must be in the future!")
    private LocalDate dateOfAppointment;

    @BooleanFlag
    private Boolean hasPassed = false;
}
