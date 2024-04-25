package algorithm.sorting.bubblesort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] myArray1 = {2, 4, 5, 6, 1, 3};
        bubbleSort(myArray1);
        System.out.println(Arrays.toString(myArray1));
    }

    private static void bubbleSort(int[] arr) {
        for(int i = arr.length -1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Bubble Sort has a efficient Space Complexity - HIGHLIGHT
    
}
