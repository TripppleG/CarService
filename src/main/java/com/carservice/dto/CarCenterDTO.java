package com.carservice.dto;

import com.carservice.data.entity.Appointment;
import com.carservice.data.entity.Employee;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.CarBrand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarCenterDTO {
   private Long id;
   private String name;
   private CarBrand workWithBrand;
   private Set<Employee> employees;
   private Set<Appointment> appointmentHistory;
   private Set<ServiceJob> serviceJobHistory;
}