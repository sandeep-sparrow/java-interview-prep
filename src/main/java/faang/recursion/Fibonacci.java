package faang.recursion;

public class Fibonacci {

    public static void main(String[] args) {
        
        System.out.println(Fibonacci.recursiveFibonacci(8));
    }

    public static int recursiveFibonacci(int n){
        if(n < 0){
            return -1;
        }
        if(n == 0 || n == 1){
            return n;
        }
        return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }
    
}
