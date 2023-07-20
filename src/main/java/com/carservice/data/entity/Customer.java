package com.carservice.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class Customer extends User {
    @OneToMany(targetEntity = Car.class)
    @Column(name = "cars")
    private Set<Car> cars;

    @OneToMany(targetEntity = ServiceJob.class)
    @Column(name = "service_job_history")
    private Set<ServiceJob> serviceJobHistory;
}
