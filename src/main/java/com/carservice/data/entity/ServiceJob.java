package com.carservice.data.entity;

import com.carservice.data.enums.ServiceJobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "service_job")
public class ServiceJob {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer")
    @NotNull(message = "The customer must be set!")
    private Customer customer;

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car")
    @NotNull(message = "The car must be set!")
    private Car car;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "The type must be set!")
    private ServiceJobType type;

    @Column(name = "date_started")
    @NotNull(message = "The date of starting must be set!")
    private LocalDate dateStarted;

    @Column(name = "date_finished")
    @NotNull(message = "The date of resolving must be set!")
    private LocalDate dateFinished;

    @Column(name = "price")
    @NotNull(message = "The price cannot be empty!")
    private Double price;
}
