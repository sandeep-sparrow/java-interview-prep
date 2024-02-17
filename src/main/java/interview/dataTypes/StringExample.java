package interview.dataTypes;

public class StringExample {

    public static void main(String[] args) {

        // String is immutable in Java because of many reasons like security, caching,
        // synchronization and concurrency, and class loading

        // String are derived data type
        // String are Java objects

        // String Constant pool -> special storage in Java Heap memory used
        // to store unique string objects

        String str1 = "sandeep";
        String str2 = "sandeep";

        // return true;
        System.out.println(str1 == str2);

        String s1 = new String("Sandeep");
        String s2 = new String("Sandeep");

        // return false;
        System.out.println(s1 == s2);

        String s3 = new String("Sandeep").intern();
        String s4 = new String("Sandeep").intern();

        // return true;
        System.out.println(s3 == s4);

        // Why StringBuffer
        // in application there is need to perform several operation like substring(), equals(),
        // indexOf(), toUpperCase();

        // each time we manipulate string, a new string object is created, and all
        // previous objects will be garbage, placing strain on GC.

        // thus StringBuffer was created, which is mutable object - THREAD SAFE all method SYNC

    }
}
