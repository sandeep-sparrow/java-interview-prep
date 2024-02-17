package interview.companies.medium;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Sandeep Prajapti";
        StringBuilder stringBuilder = new StringBuilder(input);
        System.out.println(stringBuilder.reverse().toString());
    }
}
