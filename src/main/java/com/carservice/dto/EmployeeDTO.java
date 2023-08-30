package com.carservice.dto;

import com.carservice.data.entity.CarCenter;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.ServiceJobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeDTO {
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

    @Enumerated(EnumType.STRING)
    @NotNull(message = "The qualifications must be set!")
    private Set<ServiceJobType> qualifications;

    @NotNull(message = "The car center must be set!")
    private CarCenter workingAt;

    private Set<ServiceJob> serviceJobs;
}