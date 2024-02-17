package interview.companies.micro1.dsa;

import java.util.HashMap;
import java.util.Map;

/*
    Developer: Sandeep Prajapati
    Input String: "aaabddcccbaadd"
    Expected Result: "a5b2c3d4"
 */
public class CharacterCount {

    public static void main(String[] args) {

        String input = "aaabddcccbaadd";
        System.out.println("Expected Result: " + compressString(input));
    }

    public static String compressString(String input){
        // convert the string to HashMap
        HashMap<Character, Integer> hashMap = getHashMapFromInputString(input);

        // convert HashMap to string result
        return getStringFromHashMap(hashMap);
    }

    private static String getStringFromHashMap(HashMap<Character, Integer> hashMap) {

        StringBuilder stringBuilder = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : hashMap.entrySet()){
            stringBuilder.append(entry.getKey());
            stringBuilder.append(entry.getValue());
        }

        return stringBuilder.toString();
    }

    private static HashMap<Character, Integer> getHashMapFromInputString(String input) {

        // convert the string to Char Array
        HashMap<Character, Integer> integerHashMap = new HashMap<>();
        char[] charArray = input.toCharArray();

        for(char z : charArray){
            if(integerHashMap.containsKey(z)){
                integerHashMap.put(z, integerHashMap.get(z)+1);
            }else{
                integerHashMap.put(z, 1);
            }
        }
        return integerHashMap;
    }
}
