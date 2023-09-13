package com.carservice.data.entity;

import com.carservice.data.enums.ServiceJobStatus;
import com.carservice.data.enums.ServiceJobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "service_job")
public class ServiceJob {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee")
    private Employee employee;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "The type must be set!")
    private ServiceJobType type;

    @Column(name = "date_started")
    @FutureOrPresent(message = "The date started must be in the future!")
    private LocalDate dateStarted;

    @Column(name = "date_finished")
    @FutureOrPresent(message = "The date finished must be in the future!")
    private LocalDate dateFinished;

    @Column(name = "price")
    @PositiveOrZero(message = "The price can't be negative")
    private Double price;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "The status must be set!")
    private ServiceJobStatus status = ServiceJobStatus.NEW;

    @ManyToOne(targetEntity = Appointment.class)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

}
