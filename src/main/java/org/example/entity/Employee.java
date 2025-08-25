package org.example.entity;

import java.util.Arrays;
import java.util.List;

public class Employee {
    private String name;
    private String department;
    private double salary;

    private static List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR", 40000),
            new Employee("Bob", "HR", 42000),
            new Employee("Charlie", "IT", 50000),
            new Employee("David", "IT", 55000),
            new Employee("Eve", "Finance", 60000),
            new Employee("Frank", "Finance", 62000),
            new Employee("Grace", "IT", 48000)
    );

    public static List<Employee> getEmployees(){
        return employees;
    };

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + "(" + salary + ")";
    }
}

