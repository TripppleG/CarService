package com.carservice.services.implementations;

import com.carservice.data.entity.Customer;
import com.carservice.data.repository.CustomerRepository;
import com.carservice.dto.CreateCustomerDTO;
import com.carservice.dto.CustomerDTO;
import com.carservice.exceptions.CustomerNotFoundException;
import com.carservice.services.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
   private final CustomerRepository customerRepository;
   private final ModelMapper modelMapper;

   private CustomerDTO convertToCustomerDTO(Customer customer) {
      return modelMapper.map(customer, CustomerDTO.class);
   }

    @Override
    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll().stream()
                .map(this::convertToCustomerDTO)
                .collect(Collectors.toList());
    }
    @Override
    public CustomerDTO getCustomer(@Valid String customerEmail) {
        return modelMapper.map(customerRepository.findById(customerEmail)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with email " + customerEmail + " not found")), CustomerDTO.class);
    }

    @Override
    public Customer create(@Valid CreateCustomerDTO createCustomerDTO) {
        return customerRepository.save(modelMapper.map(createCustomerDTO, Customer.class));
    }

    @Override
    public Customer updateCustomer(String customerEmail, CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setEmail(customerEmail);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String customerEmail) {
        customerRepository.deleteById(customerEmail);
    }

    @Override
    public List<CustomerDTO> getCustomersByFirstName(String firstName) {
        return customerRepository.findAllByFirstName(firstName).stream()
                .map(this::convertToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getCustomersByLastName(String lastName) {
        return customerRepository.findAllByLastName(lastName).stream()
                .map(this::convertToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getCustomersByPhoneNumber(String phoneNumber) {
        return customerRepository.findAllByPhoneNumber(phoneNumber).stream()
                .map(this::convertToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByCarLicensePlate(String carLicensePlate) {
        return modelMapper.map(customerRepository.findByCarLicensePlate(carLicensePlate), CustomerDTO.class);
    }

    @Override
    public CustomerDTO getCustomerByAppointmentId(Long appointmentId) {
        return modelMapper.map(customerRepository.findByAppointmentId(appointmentId), CustomerDTO.class);
    }
}
