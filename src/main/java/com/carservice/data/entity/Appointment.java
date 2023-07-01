package com.carservice.data.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name= "customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_service_center_id")
    private CarServiceCenter carServiceCenter;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column(name = "dateOfAppointment")
    private LocalDate dateOfAppointment;

    public Appointment() {
    }
}
