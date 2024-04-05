package algorithm.sorting;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] myArray1 = {2, 4, 5, 6, 1, 3};
        buddleSort(myArray1);
        System.out.println(Arrays.toString(myArray1));
        int[] myArray2 = {2, 4, 5, 6, 1, 3};
        selectionSort(myArray2);
        System.out.println(Arrays.toString(myArray2));
    }

    public static void buddleSort(int[] array){ // sorting it in place - SPACE Complexity - O(1)
        for(int i = array.length -1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if(i != minIndex){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int temp = array[i];
            int j  = i - 1;
            while(temp < array[i]){
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }
}
