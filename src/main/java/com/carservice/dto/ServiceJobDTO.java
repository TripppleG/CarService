package com.carservice.dto;

import com.carservice.data.entity.Car;
import com.carservice.data.entity.Customer;
import com.carservice.data.enums.ServiceJobType;
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
    private Customer customer;
    private Car car;
    private ServiceJobType type;
    private LocalDate dateStarted;
    private LocalDate dateFinished;
    private Double price;
}