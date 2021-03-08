package com.macgyver.employee.management.service;

import com.macgyver.employee.management.model.Employee;

public interface EmployeeServiceInterface {

    void createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Iterable<Employee> getAllEmployees();

    void deleteById(Long id);

    void deleteAll();
}
