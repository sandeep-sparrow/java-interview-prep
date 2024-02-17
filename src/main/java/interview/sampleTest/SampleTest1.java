package interview.sampleTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class SampleTest1 {

    public static void main(String[] args) {
        removeFromCollectionJava8();
        removeFromCollectionJava7(new ArrayList<Integer>(asList(10, 20, 30, 40, 50)));

        HashMap<String, Integer> marks = new HashMap<>();

        marks.put("Math", 75);
        marks.put("English", 85);
        marks.put("Science", 95);
        marks.put("Social", 85);
        marks.put("Hindi", 75);
        marks.put("Sanskrit", 85);

    }

    public static void removeFromCollection(List<Integer> marks){
        for(Integer mark : marks){
            if(mark == 10){
                marks.remove(mark);
            }
        }
    }

    // Java 8
    public static void removeFromCollectionJava8(){
        List<Integer> collect = Stream.of(10, 20, 30, 40).collect(toList());
        collect.removeIf(integer -> integer > 20);
        collect.forEach(System.out::println);
    }

    // Java 7
    public static void removeFromCollectionJava7(List<Integer> marks){
        for(Iterator<Integer> iterator = marks.iterator(); iterator.hasNext();) {
            Integer mark = iterator.next();
            if (mark == 10) {
                iterator.remove();
            }
        }
    }
}
