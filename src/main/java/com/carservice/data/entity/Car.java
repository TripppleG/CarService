package com.carservice.data.entity;

import com.carservice.data.enums.CarBrand;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brand")
    private CarBrand brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private LocalDate year;
}
