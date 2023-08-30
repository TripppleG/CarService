package com.carservice.data.entity;

import com.carservice.data.enums.CarBrand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "car_center")
public class CarCenter {
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

    @OneToMany(targetEntity = Appointment.class, mappedBy = "carCenter")
    private Set<Appointment> appointments;

    @OneToMany(targetEntity = Employee.class, mappedBy = "workingAt")
    private Set<Employee> employees;

    @ManyToMany(targetEntity = Customer.class)
    @JoinTable(name = "car_center_customers", joinColumns = @JoinColumn(name = "car_center_id"), inverseJoinColumns = @JoinColumn(name = "customer_email"))
    private Set<Customer> customers;

    @ManyToMany(targetEntity = Car.class)
    @JoinTable(name = "car_center_cars", joinColumns = @JoinColumn(name = "car_center_id"), inverseJoinColumns = @JoinColumn(name = "car_license_plate"))
    private Set<Car> cars;

//    public Appointment addAppointment(Appointment appointment) {
//        this.appointments.add(appointment);
//        return appointment;
//    }
//
//    public Employee addEmployee(Employee employee) {
//        this.employees.add(employee);
//        return employee;
//    }
//
//    public Customer addCustomer(Customer customer) {
//        this.customers.add(customer);
//        return customer;
//    }
//
//    public Car addCar(Car car) {
//        this.cars.add(car);
//        return car;
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
//    public void removeCustomer(String email) {
//        for (Customer customer : this.customers) {
//            if (customer.getEmail().equals(email)) {
//                this.customers.remove(customer);
//                return;
//            }
//        }
//        throw new NoSuchElementException("Customer with email " + email + " does not exist!");
//    }
//
//    public void removeEmployee(String email) {
//        for (Employee employee : this.employees) {
//            if (employee.getEmail().equals(email)) {
//                this.employees.remove(employee);
//                return;
//            }
//        }
//        throw new NoSuchElementException("Employee with email " + email + " does not exist!");
//    }
//
//    public void removeCar(String licensePlate) {
//        for (Car car : this.cars) {
//            if (car.getLicensePlate().equals(licensePlate)) {
//                this.cars.remove(car);
//                return;
//            }
//        }
//        throw new NoSuchElementException("Car with license plate " + licensePlate + " does not exist!");
//    }
//
//    public void removeAppointment(Appointment appointment) {
//        this.appointments.remove(appointment);
//    }
//
//    public void removeEmployee(Employee employee) {
//        this.employees.remove(employee);
//    }
//
//    public void removeCustomer(Customer customer) {
//        this.customers.remove(customer);
//    }
//
//    public void removeCar(Car car) {
//        this.cars.remove(car);
//    }
}
