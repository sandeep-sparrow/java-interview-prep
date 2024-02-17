package interview.dataTypes;

public class StringComparison {

    public static void main(String[] args) {

        String str1 = new String("Java");
        String str2 = new String("Java");
        String str3 = "Java";
        String str4 = "Java";

        // check the reference address - hence return false;
        System.out.println(str1 == str2);

        // check the content - hence return true;
        System.out.println(str1.equals(str2));

        // check memory location - String Constant pool - hence return true;
        System.out.println(str3 == str4);

        // return false because STR3 refers to instance created in heap
        System.out.println(str3 == str1);

        // return true because the content are similar.
        System.out.println(str3.equals(str1));

    }
}
