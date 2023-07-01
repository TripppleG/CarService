package com.carservice.data.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany
    private List<Car> cars;

    @OneToMany
    @JoinColumn(name = "service_job")
    private List<ServiceJob> serviceJobs;
}
