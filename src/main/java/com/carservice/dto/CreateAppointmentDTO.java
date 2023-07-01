package com.carservice.dto;

import com.carservice.data.entity.CarServiceCenter;
import com.carservice.data.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateAppointmentDTO {
    private Long id;
    private Customer customer;
    private CarServiceCenter carServiceCenter;
    private LocalDate dateCreated;
    private LocalDate dateOfAppointment;
}
