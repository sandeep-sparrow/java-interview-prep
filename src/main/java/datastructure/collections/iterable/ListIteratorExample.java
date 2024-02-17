package datastructure.collections.iterable;

import java.util.*;

public class ListIteratorExample {

    // ListIterator method names
    // hasNext(), Next(), remove(), add(), set(), previous(); n
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("22", "25", "54", "34", "26"));
        ListIterator<String> lIt = stringList.listIterator(); // ^ 22 25 54 34 26
        lIt.next(); // 22 ^ 25 54 34 26
        lIt.next(); // 22 25 ^ 54 34 26


    }
}
