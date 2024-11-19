package interview.companies.jpmc.dsa.arrays;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = (n+1)*(n+2)/2;
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }
        return totalSum - arraySum;
    }

    public static void main(String[] args) {
        int[] nums =  {1, 2, 4, 6, 3, 7};
        System.out.println("Missing number: " + missingNumber(nums));
    }
}
