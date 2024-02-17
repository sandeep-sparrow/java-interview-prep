package datastructure.collections.queue.example;

import java.util.PriorityQueue;

public class EmployeePriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Employee> employees = new PriorityQueue<>(10, new EmployeeComparator());
        employees.add(new Employee("Sandeep", 118000.00));
        employees.add(new Employee("Heenal", 45000.00));
        employees.add(new Employee("Dhairya", 100.00));
        employees.add(new Employee("Bhargavi", 0.00));

        System.out.println(employees.poll());
    }

}
