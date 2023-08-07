package com.carservice.data.entity;

import com.carservice.data.enums.ServiceJobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee")
public class Employee extends User {
    @ElementCollection(targetClass = ServiceJobType.class, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_qualifications", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "qualifications")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "The qualifications must be set!")
    private Set<ServiceJobType> qualifications;

    @ManyToOne(targetEntity = CarCenter.class)
    @JoinColumn(name = "working_at")
    @NotNull(message = "The service center must be set!")
    private CarCenter workingAt;

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
}
