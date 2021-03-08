package com.macgyver.employee.management.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "employee_table")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "first_name" )
    private  String firstName;

    @Column(name = "last_name")
    private  String lastName;

    @Column(name = "email")
    private  String email;

    @Column(name = "department")
    private  String department;

    @Column(name = "contact_number")
    private  Long contactNumber;

    public Employee(Long id,
                    String firstName,
                    String lastName,
                    String email,
                     String department,
                    Long contactNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.contactNumber = contactNumber;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public Long getContactNumber() {
        return contactNumber;
    }
}
