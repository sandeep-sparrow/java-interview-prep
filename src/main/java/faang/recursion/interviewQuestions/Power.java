package faang.recursion.interviewQuestions;

public class Power {

    public static void main(String[] args) {

        System.out.println(power(3, 2));
        
    }

    public static int power(int x, int n){
        // Step1: find the recursive case
        // Step2: find the base case
        // Step3: find inconsistant case
        if(n < 0){
            return -1;
        }
        if(n == 0){
            return 1;
        }
        return x * power(x, n-1);
    }
    
}
