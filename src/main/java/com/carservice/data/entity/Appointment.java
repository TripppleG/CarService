package com.carservice.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jdk.jfr.BooleanFlag;
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
    @Column(name = "id")
    private Long id;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name= "customer_email")
    @NotNull(message = "The customer must be set!")
    private Customer customer;

    @ManyToOne(targetEntity = CarCenter.class)
    @JoinColumn(name = "car_center_id")
    @NotNull(message = "The car center must be set!")
    private CarCenter carCenter;

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car_license_plate")
    @NotNull(message = "The car must be set!")
    private Car car;

    @Column(name = "date_created")
    @NotNull(message = "The date created must be set!")
    private final LocalDate dateCreated = LocalDate.now();

    @Column(name = "date_of_appointment")
    @NotNull(message = "The date of appointment must be set!")
    @Future(message = "The date of appointment must be in the future!")
    private LocalDate dateOfAppointment;

    @OneToMany(targetEntity = ServiceJob.class, mappedBy = "appointment")
    @Column(name = "serviceJobs")
    @NotNull(message = "The service jobs must be set!")
    private List<ServiceJob> serviceJobs;

    @Column(name = "has_passed")
    @BooleanFlag
    private Boolean hasPassed = false;
}