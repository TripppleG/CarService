package com.carservice.web.view.model;

import com.carservice.data.entity.Appointment;
import com.carservice.data.entity.Car;
import com.carservice.data.entity.Customer;
import com.carservice.data.entity.Employee;
import com.carservice.data.enums.CarBrand;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CarCenterViewModel {
    private Long id;

    @NotBlank(message = "The name cannot be empty")
    @Size(max = 30, message = "The name cannot be longer than {max} characters")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "The brand must be set!")
    private CarBrand workWithBrand;

    private Set<Appointment> appointments;

    private Set<Employee> employees;

    private Set<Customer> customers;

    private Set<Car> cars;
}
