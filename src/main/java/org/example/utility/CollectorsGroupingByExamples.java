package org.example.utility;

import org.example.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsGroupingByExamples {

    private List<Employee> employees = Employee.getEmployees();

    public void getEmpListByDept() {
        Map<String, List<Employee>> empsByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        empsByDept.forEach((dept, empList)->{
            System.out.println("Dept: "+dept);
            System.out.println("Employees list:");
            empList.forEach(System.out::println);
        });
    }

    public void getEmpsCountByDept() {
        Map<String, Long> empCountByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting())
                );

        empCountByDept.forEach((dept, empCnt)->{
            System.out.println("Dept: "+dept+", emp count:"+empCnt);
        });
    }

    public void getAvgSalByDept() {
        Map<String, Double> avgSalByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                        )
                );

        System.out.println(avgSalByDept);
    }

    public void getHighPaidEmpByDept() {
        Map<String, Optional<Employee>> highPaidEmpByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                        )
                );

        highPaidEmpByDept.forEach((dept, optEmp)->{
            System.out.println("Dept: "+dept);
            optEmp.ifPresent(System.out::println);
        });
    }

    public void getEmpNamesByDept() {
        Map<String, List<String>> empNamesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(
                                Employee::getName,
                                Collectors.toList()
                                )
                ));

        System.out.println(empNamesByDept);
    }

    public void groupByEmpNamesFirstLetterGroupByDept() {
        Map<String, Map<Character, List<String>>> list = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.mapping(
                    Employee::getName,
                    Collectors.groupingBy(
                            e->e.charAt(0),
                            Collectors.toList())
                    )
                )
            );

        System.out.println(list);
    }

    public void groupByEmpNamesLengthGroupByDept() {
        Map<String, Map<String, List<String>>> list = employees.stream()
                .collect(Collectors.groupingBy(
                Employee::getDepartment,
                    Collectors.mapping(
                           Employee::getName,
                           Collectors.groupingBy(
                                   e->e.length() > 3 ? "Long Name" : "Short Name",
                                   Collectors.toList()
                           )
                    )
        ));

        System.out.println(list);
    }

    public void getAvgSalByNameFirstCharByDept() {
        Map<String, Map<Character, Double>> list = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                    Collectors.groupingBy(
                            e->e.getName().charAt(0),
                            Collectors.averagingDouble(Employee::getSalary)
                    )
                )
        );

        System.out.println(list);
    }

    public void findFirstNonRepeatingCharInGivenStr() {
        String input = "javja";
        Character nonRepeatingChar = input.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        c->c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e->e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First non repeating char: "+nonRepeatingChar);
    }
}
