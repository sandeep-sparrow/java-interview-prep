package interview.puzzle;

/*
    Developer: Tech with Jatin
    Input Array: [1, 2, 1, 4, 2]
    Find Target: 4 (non duplicate)
    Restriction: No use of HashMap or HashSet
 */
public class FindSingleNumber {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 1, 4, 2};
        int result = 0;

        for (int number : numbers) {
            // XOR operation - if bit same output is 0, int different output is zero
            result = result ^ number;
        }

        System.out.println("Result: " + result);
    }
}
