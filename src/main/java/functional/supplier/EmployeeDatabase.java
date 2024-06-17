package functional.supplier;

public class EmployeeDatabase {
    public static Employee getEmployeeById(String id) {
        // Simulate a delay in fetching data from a database
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Return a dummy employee for demonstration purposes
        return new Employee(id, "John Doe", "Engineering");
    }
}
