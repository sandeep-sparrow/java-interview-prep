package interview.dec2024;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class currency_type {
    public static void main(String[] args) {

        int scale = 4;
        double value = 20.11111;
        BigDecimal tempBig = new BigDecimal(Double.toString(value));
        System.out.println(tempBig);
        tempBig = tempBig.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
        String strValue = tempBig.stripTrailingZeros().toPlainString();
        System.out.println("tempBig = " + tempBig);

        System.out.println("tempBig = " + format_rupees((new BigDecimal(20.1111)).doubleValue()));
    }

    static String format_rupees(double value) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(5);
        return format.format(value);
    }
}
