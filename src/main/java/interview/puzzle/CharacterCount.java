package interview.puzzle;

import java.util.HashMap;
import java.util.Map;

/*
    Developer: Sandeep Prajapati
    Input String: aaabdcdcaabcdd
    Expected output: a5b2c3d4
*/
public class CharacterCount {

    public static void main(String[] args) throws InterruptedException {

        String input = "aaabdcdcaabcdd";
        // Time complexity is O(n^2)
        String compressedString = compressString(input);

        System.out.println("Given string: " + input);
        System.out.println("Expected output: " + compressedString);
    }

    public static String compressString(String input) throws InterruptedException{
        // error handling
        if(input == null || input.isEmpty()){
            throw new InterruptedException("Input string cannot be empty or null");
        }

        // convert the String to charArray and getCharacterIntegerHashMap
        HashMap<Character, Integer> charMap = getCharacterIntegerHashMap(input);

        // get String from HashMap using StringBuilder
        return getStringFromHashMap(charMap);
    }

    private static String getStringFromHashMap(HashMap<Character, Integer> charMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            stringBuilder.append(key);
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }

    private static HashMap<Character, Integer> getCharacterIntegerHashMap(String input) {
        char[] inputArray = input.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char c : inputArray){
            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c)+1);
            }else{
                charMap.put(c, 1);
            }
        }
        return charMap;
    }
}
