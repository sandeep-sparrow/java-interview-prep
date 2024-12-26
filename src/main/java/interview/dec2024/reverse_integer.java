package interview.dec2024;

import java.util.Stack;

public class reverse_integer {
    public static void main(String[] args) {
        int x = 123; // Input
        String str = String.valueOf(x);
        int reversed = reverse_using_math(x);
        System.out.println("reverse_using_math: " + reversed); // Output: 321

        System.out.println("reverse_using_string_builder: " + Integer.parseInt(reverse_using_string_builder(x)));

        System.out.println("reverse_using_loop: " + Integer.parseInt(reverse_using_loop(x)));

        System.out.println("reverse_using_recursion: " + Integer.parseInt(reverse_using_recursion(str)));

        System.out.println("reverse_using_stack: " + Integer.parseInt(reverse_using_stack(x)));

        System.out.println("reverse_using_java8: " + Integer.parseInt(reverse_using_java8(x)));
    }

    public static int reverse_using_math(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;  // Extract the last digit
            x /= 10;            // Remove the last digit

            // Check for overflow/underflow
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7))
                return 0; // Overflow case
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8))
                return 0; // Underflow case

            reversed = reversed * 10 + digit; // Append the digit
        }
        return reversed;
    }

    public static String reverse_using_string_builder(int x) {
        String str = String.valueOf(x);
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverse_using_loop(int x) {
        String str = String.valueOf(x);
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    public static String reverse_using_recursion(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverse_using_recursion(str.substring(1)) + str.charAt(0);
    }

    public static String reverse_using_stack(int x) {
        String str = String.valueOf(x);
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while(!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static String reverse_using_java8(int x) {
        String str = String.valueOf(x);
        return str.chars()
                .mapToObj(c -> (char)c)
                .reduce("", (s,c) -> c + s, (s1, s2) -> s2 + s1);
    }
}
