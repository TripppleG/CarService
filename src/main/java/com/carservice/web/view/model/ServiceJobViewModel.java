package com.carservice.web.view.model;

import com.carservice.data.entity.Car;
import com.carservice.data.entity.Customer;
import com.carservice.data.entity.Employee;
import com.carservice.data.enums.ServiceJobStatus;
import com.carservice.data.enums.ServiceJobType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ServiceJobViewModel {
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
