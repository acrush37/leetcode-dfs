package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

    For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively.
    Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

    Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.
 */
public class EmployeeImportance {

    private int result;

    public static void main(String... args) {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        employee1.subordinates = Arrays.asList(2, 3);
        employee2.id = 2;
        employee2.importance = 3;
        employee3.id = 3;
        employee3.importance = 3;
        EmployeeImportance employeeImportance = new EmployeeImportance();
        System.out.println(employeeImportance.getImportance(Arrays.asList(employee1, employee2, employee3), 1));
    }

    static class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates = new ArrayList<>();
    }

    private void dfs(Employee[] a, int id) {

        result += a[id].importance;
        for (int i : a[id].subordinates) dfs(a, i);
    }

    public int getImportance(List<Employee> employees, int id) {

        result = 0;
        Employee[] a = new Employee[2001];
        employees.forEach(i -> a[i.id] = i);
        dfs(a, id);
        return result;
    }

}
