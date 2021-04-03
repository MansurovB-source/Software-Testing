package logarithmicFunction;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public interface LogarithmicFunction {
    double PRECISION = 0.0001;
    double MAX_ITERATION = 100_000;

    int BASE_1 = 2;
    int BASE_3 = 3;
    int BASE_5 = 5;
    int BASE_10 = 10;

    static boolean isValidBase(int base) {
        return base == BASE_1 || base == BASE_3 || base == BASE_5 || base == BASE_10;
    }

    static boolean isValid(double value) {
        return !Double.isNaN(value) && !Double.isInfinite(value) && !(Double.compare(0.0, value) >= 0);
    }

    default double apply(double value) {
        throw new UnsupportedOperationException();
    }

    default double apply(double value, int base) {
        throw new UnsupportedOperationException();
    }

}
