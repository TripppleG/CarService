package com.carservice.data.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Customer customer;

    @Column(name = "date_created")
    @NonNull
    private LocalDate dateCreated;

    @Column(name = "date_of_appointment")
    @NonNull
    private LocalDate dateOfAppointment;

    @ManyToOne(targetEntity = ServiceJob.class)
    @JoinColumn(name = "service_center")
    @NonNull
    private CarCenter carCenter;

    @OneToMany(targetEntity = ServiceJob.class)
    @JoinColumn(name = "service_jobs")
    private Set<ServiceJob> serviceJobs;
}


