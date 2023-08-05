package com.carservice.dto;

import com.carservice.data.entity.Car;
import com.carservice.data.entity.Customer;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.CarBrand;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<Car> cars;
    private Set<ServiceJob> serviceJobHistory;
}