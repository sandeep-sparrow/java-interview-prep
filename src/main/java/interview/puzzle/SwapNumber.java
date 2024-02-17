package interview.puzzle;

public class SwapNumber {

    public static void main(String[] args) {

        int x = 30;
        int y = 20;

        x = x + y; // 50
        y = x - y; // 50 - 30 = 20
        x = x - y; // 50 - 20 = 30

        System.out.println(x);
        System.out.println(y);
    }

}
