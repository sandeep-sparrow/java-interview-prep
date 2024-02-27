package faang.recursion;

public class Factorial {

    public static void main(String[] args) {
        
        Factorial.recursiveFactorial(5);
    }

    public static void recursiveFactorial(int n) {
        if(n < 1){
            System.out.println("n is less than 1");
        }else{
            recursiveFactorial(n-1);
            System.out.println(n);
        }
    }
    
}
