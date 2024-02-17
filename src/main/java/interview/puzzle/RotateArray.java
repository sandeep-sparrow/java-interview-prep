package interview.puzzle;

import java.util.Arrays;

/*
    Developer: Sandeep Prajapati
    Input Array: [1, 2, 3, 4, 5, 6]
    Order K = 2
    Ouput Array: [6, 5, 1, 2, 3, 4]
 */
public class RotateArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        int order = 2;
        int a = arr.length - order;
        System.out.println("a: " + a);

        reverse(arr, 0, a-1); // 0, 3
        System.out.println(Arrays.toString(arr));
        reverse(arr, a, arr.length-1); // 4, 5
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0, arr.length-1); // 0, 5
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1) return;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
