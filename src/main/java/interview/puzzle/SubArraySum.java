package interview.puzzle;

import java.util.HashMap;
import java.util.Map;

/*
    Developer: Sandeep R Prajapati
    Input Integer Array = {1, 2, 4, 6, 4, 2}
    Target: 12
    Expected Sub Array Result = {2, 4, 6}, {6, 4, 2}
 */
public class SubArraySum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 4, 2};
        Map<Integer, Integer> results = subArraySum(nums, 12);

        for(Map.Entry<Integer, Integer> key : results.entrySet()){
            if(key.getKey() != -1){
                System.out.println("Start Index is: " + key.getKey() + " End Index is: " + key.getValue());
            }else{
                System.out.println("No Matching Sub Array found!");
            }
        }
    }

    public static Map<Integer, Integer> subArraySum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        map.put(0, 1);
        int currentSum = 0;

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            if(map.containsKey(currentSum -target)){
                resultMap.put(map.get(currentSum-target)+1, i);
            }else{
                map.put(currentSum, i);
            }
        }
        if(resultMap.isEmpty()){
            resultMap.put(-1, -1);
        }
        return resultMap;
    }
}
