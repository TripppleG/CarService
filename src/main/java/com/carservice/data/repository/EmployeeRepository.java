package com.carservice.data.repository;

import com.carservice.data.entity.Employee;
import com.carservice.data.entity.ServiceJob;
import com.carservice.data.enums.ServiceJobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByQualifications(ServiceJobType qualifications);
    Optional<Employee> findByEmployeeId(String employeeId);
    List<Employee> findAllBy();
    List<Employee> findAllByServiceJobs(ServiceJob serviceJob);

}
