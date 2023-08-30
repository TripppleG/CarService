package com.carservice.services.implementations;

import com.carservice.data.entity.Employee;
import com.carservice.data.enums.ServiceJobType;
import com.carservice.data.repository.EmployeeRepository;
import com.carservice.dto.EmployeeDTO;
import com.carservice.exceptions.EmployeeNotFoundException;
import com.carservice.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    private EmployeeDTO convertToEmployeeDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployee(String employeeEmail) {
        return modelMapper.map(employeeRepository.findById(employeeEmail)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with email " + employeeEmail + " not found")), EmployeeDTO.class);
    }

    @Override
    public Employee create(@Valid EmployeeDTO employeeDTO) {
        return employeeRepository.save(modelMapper.map(employeeDTO, Employee.class));
    }

    @Override
    public Employee updateEmployee(String employeeEmail, EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setEmail(employeeEmail);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String employeeEmail) {
        employeeRepository.deleteById(employeeEmail);
    }

    @Override
    public List<EmployeeDTO> getEmployeesByFirstName(String firstName) {
        return employeeRepository.findAllByFirstName(firstName).stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeesByLastName(String lastName) {
        return employeeRepository.findAllByLastName(lastName).stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeesByPhoneNumber(String phoneNumber) {
        return employeeRepository.findAllByPhoneNumber(phoneNumber).stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeesByQualification(ServiceJobType qualification) {
        return employeeRepository.findAllByQualification(qualification).stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeesByCarCenterName(String carCenterName) {
        return employeeRepository.findAllByCarCenterName(carCenterName).stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }
}
