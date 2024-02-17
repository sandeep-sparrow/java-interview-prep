package datastructure.collections.iterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterableExample {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(Arrays.asList("22", "25", "54", "34", "26"));
        Iterator<String> it = stringList.iterator();

        System.out.println(stringList);
        System.out.println(it);

        while(it.hasNext()){
            String e = it.next();
            if("34".equals(e) || "54".equals(e)){
                it.remove();
            }
        }

        System.out.println(stringList);
    }
}
