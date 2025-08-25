package org.example;

import org.example.entity.Employee;
import org.example.utility.CollectorsGroupingByExamples;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CollectorsGroupingByExamples examples = new CollectorsGroupingByExamples();


        //1. Group employees by department
        // examples.getEmpListByDept();

        //2. Count employees in each department
        // examples.getEmpsCountByDept();

        //3. Find average salary per department
        // examples.getAvgSalByDept();

        //4. Find highest paid employee per department
        // examples.getHighPaidEmpByDept();

        //5. Collect employee names per department (not whole objects)
        // examples.getEmpNamesByDept();
    }
}