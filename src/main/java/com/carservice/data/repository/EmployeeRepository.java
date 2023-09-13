package com.carservice.data.repository;

import com.carservice.data.entity.Employee;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.ServiceJobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByEmail(String email);

    List<Employee> findAllByFirstName(String firstName);

    List<Employee> findAllByLastName(String lastName);

    List<Employee> findAllByPhoneNumber(String phoneNumber);

    @Query("SELECT e FROM Employee e JOIN e.qualifications qualification WHERE qualification = ?1")
    List<Employee> findAllByQualification(ServiceJobType qualification);

    @Query("SELECT e FROM Employee e JOIN e.workingAt carCenter WHERE carCenter.name = ?1")
    List<Employee> findAllByCarCenterName(String carCenterName);
}
