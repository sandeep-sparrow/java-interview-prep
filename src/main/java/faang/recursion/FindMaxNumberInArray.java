package faang.recursion;

public class FindMaxNumberInArray {

    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        System.out.println(findMaxInArray(arr, n));
    }

    public static int findMaxInArray(int[] arr, int n){ // -> M(n)
        if(n==1) // -> O(1)
            return arr[0]; // -> O(1)
        return Math.max(arr[n-1], findMaxInArray(arr, n-1)); // -> M(n-1)
    }
    
    
}
