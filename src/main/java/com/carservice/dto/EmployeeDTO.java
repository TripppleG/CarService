package com.carservice.dto;

import com.carservice.data.entity.CarCenter;
import com.carservice.data.enums.ServiceJobType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private CarCenter workingAt;
}