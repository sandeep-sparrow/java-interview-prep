package algorithm.sorting.revision;

import java.util.*;

public class RevisionSort {

    public static void main(String[] args) {
        int[] myArray1 = {2, 4, 5, 6, 1, 3};
        bubbleSort(myArray1);
        System.out.println("Buble Sort " + Arrays.toString(myArray1));
        selectionSort(myArray1);
        System.out.println("Selection Sort " + Arrays.toString(myArray1));
        insertionSort(myArray1);
        System.out.println("Insertion Sort " + Arrays.toString(myArray1));
    }

    private static void insertionSort(int[] myArray1) {
        for(int i = 1; i < myArray1.length; i++){
            int temp = myArray1[i];
            int j = i-1;
            while (j > -1 && temp < myArray1[j]) {
                myArray1[j+1]=myArray1[j];
                myArray1[j]=temp;
                j--;
            }
        }
    }

    private static void selectionSort(int[] myArray1) { // Straight Forward most simplest
        for(int i = 0; i < myArray1.length; i++){
            int minIndex = i;
            for(int j = i+1; j < myArray1.length; j++){
                if(myArray1[j] < myArray1[minIndex]){
                    minIndex = j;
                }
            }
            if(i != minIndex){
                int temp = myArray1[i];
                myArray1[i] = myArray1[minIndex];
                myArray1[minIndex] = temp;
            }
        }
    }

    private static void bubbleSort(int[] myArray1) { // Most efficient in terms of space complexity
        for(int i = myArray1.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(myArray1[j] > myArray1[j+1]){
                    int temp = myArray1[j];
                    myArray1[j] = myArray1[j+1];
                    myArray1[j+1] = temp;
                }
            }
        }
    }
    
}
