package com.carservice.data.entity;

import com.carservice.data.enums.CarBrand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDate;
import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "license_plate")
    @Pattern(regexp = "[A-Z]{2}[0-9]{4}[A-Z]{2}", message = "License plate must be in format: XX0000XX")
    private String licensePlate;

    @Column(name = "brand")
    @NotNull(message = "Brand must be set!")
    @Enumerated(EnumType.STRING)
    private CarBrand brand;

    @NotBlank(message = "Model cannot be blank!")
    @Size(max = 15, message = "Model can be up to {max} characters!")
    private String model;

    @Column(name = "year")
    @Pattern(regexp = "[0-9]{4}", message = "Year must be in format: YYYY")
    @NotNull(message = "Year must be set!")
    private LocalDate year;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "owner")
    @NotNull(message = "Owner must be set!")
    private Customer owner;
}
