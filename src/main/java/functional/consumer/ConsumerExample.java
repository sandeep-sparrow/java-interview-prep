package functional.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("1", "Alice", 50000),
                new Employee("2", "Bob", 55000),
                new Employee("3", "Charlie", 60000)
        );

        // Define a Consumer to print employee details
        Consumer<Employee> printEmployee = employee -> System.out.println(employee);

        // Define a Consumer to give a bonus to employees
        Consumer<Employee> giveBonus = employee -> employee.giveBonus(5000);

        // Process the list of employees with the Consumers
        System.out.println("Printing employee details:");
        processEmployees(employees, printEmployee);

        System.out.println("\nGiving bonuses to employees:");
        processEmployees(employees, giveBonus);

        System.out.println("\nPrinting updated employee details:");
        processEmployees(employees, printEmployee);
    }

    public static void processEmployees(List<Employee> employees, Consumer<Employee> consumer) {
        for (Employee employee : employees) {
            consumer.accept(employee);
        }
    }
}
