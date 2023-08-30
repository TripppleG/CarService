package com.carservice.web.api;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee-{employeeId}/employee")
@AllArgsConstructor
@Validated
public class EmployeeApiController {
}

