package com.carservice.dto;

import com.carservice.data.entity.Appointment;
import com.carservice.data.entity.Employee;
import com.carservice.data.entity.ServiceCenter;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.CarBrand;
import com.carservice.data.enums.ServiceJobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ServiceCenterDTO {
   private Long id;
   private String name;
   private CarBrand workWithBrand;
   private Set<Employee> employees;
   private Set<Appointment> appointmentHistory;
   private Set<ServiceJob> serviceJobHistory;
}