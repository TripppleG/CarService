package com.carservice.dto;

import com.carservice.data.entity.Car;
import com.carservice.data.entity.ServiceCenter;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.ServiceJobType;
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
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<ServiceJobType> qualifications;
    private ServiceCenter workingAt;
}