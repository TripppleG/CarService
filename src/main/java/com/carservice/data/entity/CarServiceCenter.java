package com.carservice.data.entity;

import com.carservice.data.enums.CarBrand;
import jakarta.persistence.*;

@Entity
@Table(name = "car_service_center")
public class CarServiceCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private CarBrand workWithBrand;
}
