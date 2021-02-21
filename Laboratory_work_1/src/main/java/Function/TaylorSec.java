package Function;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class TaylorSec {
    public static final double epsilon = 1E-9;

    private static BigInteger factorial(int n) {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static double sec(double x) {
        double current;
        double prev;
        double numerator = 1.0;
        int n = 1;
        do {
            prev = 1 / numerator;
            numerator += (Math.pow(-1, n) * Math.pow(x, 2 * n)) / Double.parseDouble(factorial(2 * n).toString());
            current = 1 / numerator;
            n++;
        } while (Math.abs(current - prev) >= epsilon);
        return current;
    }

}
