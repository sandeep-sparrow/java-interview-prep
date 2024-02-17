package interview.puzzle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums, find the subarray with the largest sum,
 and return its sum and the subarray
 A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6,  [4,-1,2,1]
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Input: nums = [-2,-3,-2,-5, -1]
Output: -1,  [-1]
Explanation: The subarray [-1] has the largest sum -1.


Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
public class SubSumArrayMax {

    public static void main(String[] args) {
        int[] numbers = {-2,-3,-2,-5, -1};
        int maxSum = findLargestSubArraySum(numbers);

        System.out.println("Max Sum: " + maxSum);

        HashMap<Integer, Integer> results = subSumArray(numbers, maxSum);

        for(Map.Entry<Integer, Integer> key : results.entrySet()){
            if(key.getValue() != -1){
                System.out.println("Start Index is: " + key.getKey() + " End Index is: " + key.getValue());
                int[] maxSubArray = Arrays.copyOfRange(numbers, key.getKey(), key.getValue()+1);
                System.out.println("Original Array: " + Arrays.toString(numbers));
                System.out.println("Max Sub Array: " + Arrays.toString(maxSubArray));
            }else {
                System.out.println("No Matching Sub Array found!");
            }
        }
    }

    public static HashMap<Integer, Integer> subSumArray(int[] nums, int target){
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        HashMap<Integer, Integer> resultHashMap = new HashMap<>();

        integerHashMap.put(0, 1);
        int currentSum = 0;

        for(int i = 0; i < nums.length; i++){
            currentSum +=  nums[i];
            if(integerHashMap.containsKey(currentSum - target)){
                resultHashMap.put(integerHashMap.get(currentSum - target)+1, i);
            }else{
                integerHashMap.put(currentSum, i);
            }
        }
        if(resultHashMap.isEmpty()){
            resultHashMap.put(-1, -1);
        }

        return resultHashMap;
    }

    public static int findLargestSubArraySum(int[] nums) {
        /*
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6,  [4,-1,2,1]
         */
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int maxEndingHere = nums[0]; // -2
        int maxSoFar = nums[0]; // -2

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
