package com.carservice.dto;

import com.carservice.data.entity.*;
import com.carservice.data.enums.CarBrand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
public class CustomerDTO {
    @Size(min = 6, max = 64, message = "The email must be at least {min} characters long!")
    @NotBlank(message = "The email cannot be empty!")
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank(message = "The phone number cannot be empty!")
    @Pattern(regexp = "^\\+359\\d{9}$", message = "The phone number must be in the format +359xxxxxxxxx!")
    private String phoneNumber;

    private Set<Car> cars;

    private Set<Appointment> appointments;

    private Set<CarCenter> customerOf;
}