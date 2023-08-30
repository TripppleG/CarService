package com.carservice.services;

import com.carservice.data.entity.Customer;
import com.carservice.dto.CustomerDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getCustomers();

    CustomerDTO getCustomer(String customerEmail);


    Customer create(@Valid CustomerDTO customerDTO);

    Customer updateCustomer(String customerEmail, @Valid CustomerDTO customerDTO);

    void deleteCustomer(String customerEmail);

    List<CustomerDTO> getCustomersByFirstName(String firstName);

    List<CustomerDTO> getCustomersByLastName(String lastName);

    List<CustomerDTO> getCustomersByPhoneNumber(String phoneNumber);

    CustomerDTO getCustomerByCarLicensePlate(String carLicensePlate);

    CustomerDTO getCustomerByAppointmentId(Long appointmentId);

    CustomerDTO getCustomerByServiceCenterName(String serviceCenterName);
}
