package com.carservice.data.entity;

import com.carservice.data.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "customer")
public class Customer extends User {
    @OneToMany(targetEntity = Car.class, mappedBy = "owner")
    private Set<Car> cars;

    @OneToMany(targetEntity = Appointment.class, mappedBy = "customer")
    private Set<Appointment> appointments;

    public Customer(String email, String firstName, String lastName, String phoneNumber, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.authority = Role.CUSTOMER;
        this.cars = new HashSet<>();
        this.appointments = new HashSet<>();
    }
}