package com.carservice.services.implementations;

import com.carservice.data.entity.Employee;
import com.carservice.data.entity.User;
import com.carservice.data.repository.CustomerRepository;
import com.carservice.data.repository.EmployeeRepository;
import com.carservice.data.repository.UserRepository;
import com.carservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User customer = customerRepository.findByEmail(email);
        User employee = employeeRepository.findByEmail(email);

        if (customer != null){
            return customer;
        }

        if (employee != null){
            return employee;
        }
        throw new UsernameNotFoundException("Username not found");
    }
}
