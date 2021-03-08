package com.macgyver.employee.management.controller;

import com.macgyver.employee.management.model.Employee;
import com.macgyver.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String listEmployees(Model model){
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "index";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employee") Employee employee){
        this.employeeService.createEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/show")
    public String viewForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showForUpdate(@PathVariable (value = "id") long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Long id){
        this.employeeService.deleteById(id);
        return "redirect:/";
    }
}
