package interview.companies.deloitte;

import java.util.ArrayList;
import java.util.List;

public class Question1 {
    
    public static void main(String[] args) {
        List<String> innerWords = new ArrayList<>();
        String input = "{{there}ih}";

        int openIndex = -1;
        int closeIndex;

        while((openIndex = input.indexOf('{', openIndex + 1)) != -1){
            closeIndex = input.indexOf('}', openIndex);
            if (closeIndex != -1 && closeIndex > openIndex){
                String word = input.substring(openIndex+1, closeIndex);
                if(!word.contains(String.valueOf('{')) && !word.contains(String.valueOf('}'))){
                    innerWords.add(word);
                }
            }
        }

        System.out.println(innerWords.toString());
    }
}
