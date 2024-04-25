package algorithm.sorting.insertionsort;

import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        int[] myArray1 = {2, 4, 5, 6, 1, 3};
        insertionSort(myArray1);
        System.out.println(Arrays.toString(myArray1));
    }

    private static void insertionSort(int[] myArray1) {
        // start from the second item
        for(int i = 1; i < myArray1.length; i++){
            int temp = myArray1[i];
            int j = i-1;
            while(j > -1 && temp < myArray1[j]){
                myArray1[j+1]=myArray1[j];
                myArray1[j]=temp;
                j--;
            }
        }
    }
    
}
