package interview.dataTypes;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String s1 = "HelloWorld";
        String s2 = "HelloWorld";
        String s3 = new String(s1);
        if (s1 == s2)
            System.out.print("1");
        if (s2 == s3)
            System.out.print("2");
        if (s1.equals(s3))
            System.out.print("3");
        String s = "HelloWorld".substring(5,10);
        System.out.println(s);
        Integer a = new Integer(4);
        Integer b = new Integer(8);
        Integer c = new Integer(4);
        @SuppressWarnings("rawtypes")
        Set hs = new LinkedHashSet();
        hs.add(a);
        hs.add(b);
        hs.add(c);
        System.out.println(hs);
    }
}
