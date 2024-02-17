package datastructure.collections.stack.usage;

import java.util.Stack;

public class BalancedParantheses {

    public static void main(String[] args) {
        testAndPrint("()", true);
        testAndPrint("{if(a==b) return true else false}", true);
        testAndPrint("()()", true);
        testAndPrint("(())", true);
        testAndPrint("()()()", true);
        testAndPrint("(()())", true);
        testAndPrint(")()(", false);
        testAndPrint(")(", false);
        testAndPrint("(()", false);
        testAndPrint("))", false);
        testAndPrint("(", false);
        testAndPrint(")", false);
    }

    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }

    public static boolean isBalancedParentheses(String s){
        Stack<Character>  stk = new Stack<>();

        if(s.isEmpty()) return true;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(!stk.isEmpty() && stk.peek() == '('){
                    stk.pop();
                }else{
                    return false;
                }
            }else if(s.charAt(i) == ']'){
                if(!stk.isEmpty() && stk.peek() == '['){
                    stk.pop();
                }else{
                    return false;
                }
            }else if(s.charAt(i) == '}'){
                if(!stk.isEmpty() && stk.peek() == '{'){
                    stk.pop();
                }else{
                    return false;
                }
            }else{
                if(s.charAt(i) == '('){
                    stk.push(s.charAt(i));
                }else if(s.charAt(i) == '['){
                    stk.push(s.charAt(i));
                }else if(s.charAt(i) == '{'){
                    stk.push(s.charAt(i));
                }
            }
        }
        return stk.isEmpty();
    }

}
