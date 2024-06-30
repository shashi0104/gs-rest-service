package com.example.restservice;

public class EmployeeManager {
    private Employees employees;

    public EmployeeManager() {
        employees = new Employees();
        initializeEmployees();
    }

    private void initializeEmployees() {
        Employee emp1 = new Employee();
        emp1.setEmployee_id(1L);
        emp1.setFirst_name("John");
        emp1.setLast_name("Doe");
        emp1.setEmail("john.doe@example.com");
        emp1.setTitle("Developer");

        Employee emp2 = new Employee();
        emp2.setEmployee_id(2L);
        emp2.setFirst_name("Jane");
        emp2.setLast_name("Smith");
        emp2.setEmail("jane.smith@example.com");
        emp2.setTitle("Manager");

        employees.getEmployeeList().add(emp1);
        employees.getEmployeeList().add(emp2);
    }

    public Employees getEmployees() {
        return employees;
    }
}
