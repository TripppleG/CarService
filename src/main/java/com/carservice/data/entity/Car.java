package com.carservice.data.entity;

import com.carservice.data.enums.CarBrand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "license_plate")
    @Pattern(regexp = "[A-Z]{2}[0-9]{4}[A-Z]{2}", message = "License plate must be in format: XX0000XX")
    private String licensePlate;

    @Column(name = "brand")
    @NotNull(message = "Brand must be set!")
    @Enumerated(EnumType.STRING)
    private CarBrand brand;

    @Column(name = "model")
    @NotBlank(message = "Model cannot be blank!")
    @Size(max = 15, message = "Model can be up to {max} characters!")
    private String model;

    @Column(name = "year")
    @Pattern(regexp = "[0-9]{4}", message = "Year must be in format: YYYY")
    @NotNull(message = "Year must be set!")
    private LocalDate year;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "owner_email")
    @NotNull(message = "Owner must be set!")
    private Customer owner;

    @OneToMany(targetEntity = Appointment.class, mappedBy = "car")
    private Set<Appointment> appointments;

    @OneToMany(targetEntity = ServiceJob.class, mappedBy = "car")
    private Set<ServiceJob> serviceJobs;

    @ManyToMany(targetEntity = CarCenter.class, mappedBy = "cars")
    private Set<CarCenter> carCenters;

//    public Appointment addAppointment(Appointment appointment) {
//        this.appointments.add(appointment);
//        return appointment;
//    }
//
//    public ServiceJob addServiceJob(ServiceJob serviceJob) {
//        this.serviceJobs.add(serviceJob);
//        return serviceJob;
//    }
//
//    public CarCenter addCarCenter(CarCenter carCenter) {
//        this.carCenters.add(carCenter);
//        return carCenter;
//    }
//
//    public void removeAppointment(Long id) {
//        for (Appointment appointment : this.appointments) {
//            if (appointment.getId().equals(id)) {
//                this.appointments.remove(appointment);
//                return;
//            }
//        }
//        throw new NoSuchElementException("Appointment with id " + id + " does not exist!");
//    }
//
//    public void removeServiceJob(Long id) {
//        for (ServiceJob serviceJob : this.serviceJobs) {
//            if (serviceJob.getId().equals(id)) {
//                this.serviceJobs.remove(serviceJob);
//                return;
//            }
//        }
//        throw new NoSuchElementException("Service job with id " + id + " does not exist!");
//    }
//
//    public void removeCarCenter(Long id) {
//        for (CarCenter carCenter : this.carCenters) {
//            if (carCenter.getId().equals(id)) {
//                this.carCenters.remove(carCenter);
//                return;
//            }
//        }
//        throw new NoSuchElementException("Car center with id " + id + " does not exist!");
//    }
}
