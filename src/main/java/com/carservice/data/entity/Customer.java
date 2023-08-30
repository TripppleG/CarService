package com.carservice.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer")
public class Customer extends User {
    @OneToMany(targetEntity = Car.class, mappedBy = "owner")
    private Set<Car> cars;

    @OneToMany(targetEntity = Appointment.class, mappedBy = "customer")
    private Set<Appointment> appointments;

    @ManyToMany(targetEntity = CarCenter.class, mappedBy = "customers")
    private Set<CarCenter> customerOf;
}