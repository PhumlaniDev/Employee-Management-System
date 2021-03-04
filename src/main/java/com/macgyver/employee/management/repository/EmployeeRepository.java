package com.macgyver.employee.management.repository;

import com.macgyver.employee.management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
