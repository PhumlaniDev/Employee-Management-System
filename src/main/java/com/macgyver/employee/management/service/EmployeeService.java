package com.macgyver.employee.management.service;

import com.macgyver.employee.management.model.Employee;
import com.macgyver.employee.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public void createEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;

        if(optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
        }
        else {
            try {
                throw  new RuntimeException("Employee not found for id: " + id);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
