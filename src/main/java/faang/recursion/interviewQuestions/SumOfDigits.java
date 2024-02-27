package faang.recursion.interviewQuestions;

public class SumOfDigits {

    public static void main(String[] args) {
        
        // Step1: find recursive flow
        // 10 ? divide in digit? 
        // divide by 10 -> 1 & remainder is 0 = sum of divisor and remainder is 1 + 0 = 1
        // 52 = 52/10 = 5 + 2 = 7
        // 112 = 112/10 = 11 + 2 = 13
        // 1123 = 1123/10 = 112 + 3, next step
        // 112 = 112/10 = 11 + 2 = 13 + 3 = 16

        System.out.println(sumOfDigits(235));

    }

    public static int sumOfDigits(int n){
        // Step3: inconsistant case
        // 1123
        // Step2: base condition to stop the loop
        if(n == 0 || n < 0){
            return 0;
		}
        // Step1: find recursive flow
        return n % 10 + sumOfDigits(n/10); // 3 + f(112), 3 + 2 + f(11), 3 + 2 + 1 + f(1), 3 + 2 + 1 + 1 + 0
    }
    
}
