package trigonometricFunctions;

import static java.lang.Math.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Sin implements TrigonometricFunction {

    @Override
    public double apply(double value) {
        if (!TrigonometricFunction.isValid(value)) {
            return Double.NaN;
        }

        double sign = value < 0 ? -1 : 1;
        double simply_value = simplifyValue(abs(value));
        double current = 0;
        double previous = 0;
        int n = 0;
        double x;
        do {
            previous = current;
            current += (pow(-1, n) * pow(simply_value, 2 * n + 1)) / TrigonometricFunction.factorial(2 * n + 1);
            n++;
            x = abs(current - previous);
        } while (Double.compare(abs(current - previous), PRECISION) > 0 && n < MAX_ITERATION);
        return sign * current;
    }

    private double simplifyValue(double value) {
        double remainder = value % (2 * PI);
        if (remainder <= PI && remainder > PI / 2) {
            return PI - remainder;
        } else if (remainder > 3 * PI / 2) {
            return 3 * PI - remainder;
        } else {
            return remainder;
        }
    }
}
