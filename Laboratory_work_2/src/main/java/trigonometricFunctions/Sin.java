package trigonometricFunctions;

import static java.lang.Math.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Sin implements TrigonometricFunction {
    private double result;

    public Sin(double value) {
        result = apply(value);
    }

    public Sin() {
    }

    public double getResult() {
        return result;
    }

    @Override
     public double apply(double value) {
        if (!TrigonometricFunction.isValid(value)) {
            return value;
        }
        double current = 0;
        double previous = 0;
        int n = 0;
        do {
            previous = current;
            current = (pow(-1, n) * pow(value, 2 * n + 1)) / TrigonometricFunction.factorial(2 * n + 1);
            n++;
        } while (abs(current - previous) >= PRECISION || n <= MAX_ITERATION);
        return current;
    }
}
