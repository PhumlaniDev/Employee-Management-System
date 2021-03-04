package com.macgyver.employee.management.service;

import com.macgyver.employee.management.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {

    Employee createEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    void deleteById(Long id);

    void deleteAll();
}
