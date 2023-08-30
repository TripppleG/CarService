package com.carservice.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name= "customer")
    @NotNull(message = "The customer must be set!")
    private Customer customer;

    @ManyToOne(targetEntity = CarCenter.class)
    @JoinColumn(name = "car_center")
    @NotNull(message = "The car center must be set!")
    private CarCenter carCenter;

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car")
    @NotNull(message = "The car must be set!")
    private Car car;

    @Column(name = "date_created")
    @NotNull(message = "The date created must be set!")
    @PastOrPresent(message = "The date created must not be the future!")
    private LocalDate dateCreated = LocalDate.now();

    @Column(name = "date_of_appointment")
    @NotNull(message = "The date of appointment must be set!")
    @Future(message = "The date of appointment must be in the future!")
    private LocalDate dateOfAppointment;

    @Column(name = "is_past")
    @NotNull(message = "The is past must be set!")
    private Boolean isPast = false;
}


