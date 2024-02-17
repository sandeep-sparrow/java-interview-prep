package interview.puzzle;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/*
    Developer: Sandeep Prajapati
    Input: Java
    Outpt: Jav
 */
public class DuplicateLetter {
    public static void main(String[] args) {
        // Zomato -> WTC pasta - pink penne pasta -> 3$
        // TRX1 -> success -> no
        // TRX2 -> success -> yes
        // [TRX1-failed, TRX2]
        String input = "Sandeep";

        // convert String to char Array
        char[] inputChars = input.toCharArray();

        Set<Character> inputCharSet = new LinkedHashSet<Character>();

        for(Character inputChar : inputChars){
            inputCharSet.add(inputChar);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(Character character : inputCharSet){
            stringBuilder.append(character);
        }

        System.out.println(stringBuilder.toString());
    }
}
