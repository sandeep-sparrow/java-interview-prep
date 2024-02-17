package interview.companies.medium;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 9, 7};
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Largest Number: " + max);
    }
}
