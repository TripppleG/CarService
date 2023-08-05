package com.carservice.dto;

import com.carservice.data.entity.Customer;
import com.carservice.data.enums.CarBrand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarDTO {
    String licensePlate;
    CarBrand brand;
    String model;
    LocalDate year;
    Customer owner;
}