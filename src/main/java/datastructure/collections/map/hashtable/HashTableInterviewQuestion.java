package datastructure.collections.map.hashtable;

import java.util.HashMap;
import java.util.Map;

public class HashTableInterviewQuestion {

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));
    }

    public static boolean itemInCommon(int[] array1, int[] array2){
        Map<Integer, Boolean> myHashMap = new HashMap<>();

        // n operations
        for(int i : array1){
            myHashMap.put(i, true);
        }

        // n operations
        for(int j: array2){
            if(myHashMap.get(j) != null) return true;
        }

        return false;
    }

    // Big O

    // insert, set, write
    // O(1)

    // read, get
    // 0(1)

}
