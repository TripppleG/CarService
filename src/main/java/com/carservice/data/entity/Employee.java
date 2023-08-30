package com.carservice.data.entity;

import com.carservice.data.enums.ServiceJobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "employee")
public class Employee extends User {
    @ElementCollection(targetClass = ServiceJobType.class, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_qualifications", joinColumns = @JoinColumn(name = "employee_email"))
    @Column(name = "qualifications")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "The qualifications must be set!")
    private Set<ServiceJobType> qualifications;

    @ManyToOne(targetEntity = CarCenter.class)
    @JoinColumn(name = "working_at")
    @NotNull(message = "The car center must be set!")
    private CarCenter workingAt;

    @OneToMany(targetEntity = ServiceJob.class, mappedBy = "employee")
    private Set<ServiceJob> serviceJobs;

    public void setEmail() {
        String tempMail = this.firstName + "." + this.lastName + "@" + workingAt.getName() + ".com";
        int counter = 1;
        while (workingAt.getEmployees().stream().anyMatch(employee ->
                employee.getEmail().equals(this.firstName + "." + this.lastName + "@" + workingAt.getName() + ".com"))) {
                tempMail = this.firstName + "." + this.lastName + counter + "@" + workingAt.getName() + ".com";
                counter++;
        }
        this.email = tempMail;
    }

    public Employee(String firstName, String lastName, String phoneNumber, String password, Set<ServiceJobType> qualifications, CarCenter workingAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.qualifications = qualifications;
        this.workingAt = workingAt;
        setEmail();
    }

    public void setWorkingAt() {
        setEmail();
    }
}
