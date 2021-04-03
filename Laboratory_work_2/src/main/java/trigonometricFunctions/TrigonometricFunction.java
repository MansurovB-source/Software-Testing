package trigonometricFunctions;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public interface TrigonometricFunction {
    double PRECISION = 0.0001;
    double MAX_ITERATION = 100_000;

    static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    static boolean isValid(double value) {
        return !Double.isNaN(value) && !Double.isInfinite(value);
    }

    double apply(double value);
}
