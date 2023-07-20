package com.carservice.data.entity;

import com.carservice.data.enums.CarBrand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "service_center")
public class ServiceCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "The name cannot be empty")
    @Size(max = 30, message = "The name cannot be longer than {max} characters")
    private String name;

    @Column(name = "working_with_brand")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "The brand must be set!")
    private CarBrand workWithBrand;

    @OneToMany(targetEntity = Employee.class)
    @JoinColumn(name = "employees")
    private Set<Employee> employees;

    @OneToMany(targetEntity = Appointment.class)
    @JoinColumn(name = "appointment_history")
    private Set<Appointment> appointmentHistory;
}
