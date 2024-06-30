package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeManager employeeManager = new EmployeeManager();

    @GetMapping("/employees")
    public Employees getAllEmployees() {
        return employeeManager.getEmployees();
    }
    
    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee newEmployee) {
        employeeManager.getEmployees().getEmployeeList().add(newEmployee);
    }
}
