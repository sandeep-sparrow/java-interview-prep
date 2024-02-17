package interview.puzzle;

import java.util.HashMap;
import java.util.Map;

/*
    Developer Name: Sandeep Prajapati
    Input Array: [2, 3, 5, 7, 9, 1]
    Target Value: 10
    Expected Result: [3, 7, 9, 1]
 */
public class TwoSum {

    public static HashMap<Integer, Integer> findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        HashMap<Integer, Integer> ints = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                ints.put(numMap.get(complement), i);
            }
            numMap.put(nums[i], i);
        }
        if(ints.isEmpty()){
            ints.put(-1, -1);
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 9, 2};
        int target = 10;

        // Time complexity - O(n^2)
        HashMap<Integer, Integer> results = findTwoSum(nums, target);

        for (Map.Entry<Integer, Integer> key : results.entrySet()) {
            if (key.getKey() != -1) {
                System.out.println("Two numbers found at indices: " + key.getKey() + " and " + key.getValue());
                System.out.println("Numbers are: " + nums[key.getKey()] + " and " + nums[key.getValue()]);
            } else {
                System.out.println("No such pair found.");
            }
        }
    }
}
