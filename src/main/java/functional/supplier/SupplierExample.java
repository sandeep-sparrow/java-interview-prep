package functional.supplier;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Create a Supplier for lazy loading of Employee
        // functional style lambda expression
        Supplier<Employee> employeeSupplier = () -> EmployeeDatabase.getEmployeeById("123");

        System.out.println("Before calling get() on Supplier");
        Employee employee = employeeSupplier.get(); // until this get is not invoked the supplier method is not executed
        System.out.println("After calling get() on Supplier");

        // Print the employee details
        System.out.println(employee);
    }
}
