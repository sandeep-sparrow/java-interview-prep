package interview.puzzle;

/*
    Developer: Tech with Jatin
    Input Array: [-1, 4, -6, 8]
    Find Target: max sum
    Restriction: No use of HashMap or HashSet
 */
public class MaxOfSubArray {

    public static void main(String[] args) {
        int[] numbers = {-1, 4, -6, 8};

        // Kadane's Algorithm
        int currentSum = numbers[0];
        int maxSum = numbers[0];

        for(int i = 1; i < numbers.length; i++){
             currentSum = Math.max(numbers[i], currentSum + numbers[i]);
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        // Time Complexity - O(n)
        // Space Complexity - O(1)

        System.out.println("Max Sum: " + maxSum);
    }
}
