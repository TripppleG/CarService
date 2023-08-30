package com.carservice.dto;

import com.carservice.data.entity.*;
import com.carservice.data.enums.CarBrand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CarCenterDTO {
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