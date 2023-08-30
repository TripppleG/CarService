package com.carservice.services;

import com.carservice.data.entity.Employee;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.ServiceJobType;
import com.carservice.dto.EmployeeDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getEmployees();

    EmployeeDTO getEmployee(String employeeEmail);

    Employee create(@Valid EmployeeDTO employeeDTO);

    Employee updateEmployee(String employeeEmail, EmployeeDTO employeeDTO);

    void deleteEmployee(String employeeEmail);

    List<EmployeeDTO> getEmployeesByFirstName(String firstName);

    List<EmployeeDTO> getEmployeesByLastName(String lastName);

    List<EmployeeDTO> getEmployeesByPhoneNumber(String phoneNumber);

    List<EmployeeDTO> getEmployeesByQualification(ServiceJobType qualification);

    List<EmployeeDTO> getEmployeesByCarCenterName(String carCenterName);
}
