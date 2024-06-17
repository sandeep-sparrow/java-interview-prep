package algorithm.sorting.selectionsort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] myArray1 = {2, 4, 5, 6, 1, 3, 7};
        selectionSort(myArray1);
        System.out.println(Arrays.toString(myArray1));
    }

    private static void selectionSort(int[] myArray1) {
        
        for(int i = 0; i < myArray1.length; i++){
            int minIndex = i;
            for(int j = i+1; j < myArray1.length; j++){
                if(myArray1[j] < myArray1[minIndex]){
                    minIndex = j;
                }
            }
            if(i != minIndex){
                // swap
                swap(myArray1, i, minIndex);
            }
        }
    }

    private static void swap(int[] myArray1, int i, int minIndex) {
        int temp = myArray1[i];
        myArray1[i] = myArray1[minIndex];
        myArray1[minIndex] = temp;
    }

}
