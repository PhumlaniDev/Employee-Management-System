package com.macgyver.employee.management.controller;

import com.macgyver.employee.management.model.Employee;
import com.macgyver.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmpoyeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmpoyeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String listEmployees(Model model){
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "index";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.createEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showEmployeeForm")
    public String viewForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

   /* @GetMapping("/api/v1/get/{id}/")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/")
    public String getAllEmployees( Model model){
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "index";
    }

    @DeleteMapping("api/v1/delete/{id}/")
    public void deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
    }

    @DeleteMapping("api/v1/delete/")
    public void deleteAll(){
        employeeService.deleteAll();
    }*/
}
