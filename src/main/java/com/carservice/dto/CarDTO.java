package com.carservice.dto;

import com.carservice.data.entity.Appointment;
import com.carservice.data.entity.CarCenter;
import com.carservice.data.entity.Customer;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.CarBrand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarDTO {
    @Pattern(regexp = "[A-Z]{2}[0-9]{4}[A-Z]{2}", message = "License plate must be in format: XX0000XX")
    private String licensePlate;

    @NotNull(message = "Brand must be set!")
    @Enumerated(EnumType.STRING)
    private CarBrand brand;

    @NotBlank(message = "Model cannot be blank!")
    @Size(max = 15, message = "Model can be up to {max} characters!")
    private String model;

    @Pattern(regexp = "[0-9]{4}", message = "Year must be in format: YYYY")
    @NotNull(message = "Year must be set!")
    private LocalDate year;

    @NotNull(message = "Owner must be set!")
    private Customer owner;

    private Set<Appointment> appointments;
}