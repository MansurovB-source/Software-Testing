package logarithmicFunction;

import static java.lang.Math.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Ln implements LogarithmicFunction {
    private double result;

    public Ln() {
    }

    public Ln(double value) {
        result = apply(value);
    }

    public double getResult() {
        return result;
    }

    @Override
    public double apply(double value) {
        if (!LogarithmicFunction.isValid(value)) {
            if (Double.isNaN(value) || value < 0.0) {
                return Double.NaN;
            } else if (Double.compare(Double.POSITIVE_INFINITY, value) == 0) {
                return Double.POSITIVE_INFINITY;
            } else {
                return Double.NEGATIVE_INFINITY;
            }
        }

        double z = (value - 1) / (value + 1);
        double previous;
        double current = 0;
        int n = 1;
        do {
            previous = current;
            current = pow(z, n) / n;
            n += 2;
        } while (abs(current - previous) > PRECISION || n < MAX_ITERATION);

        return 2 * current;
    }


}
