package logarithmicFunction;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Log implements LogarithmicFunction {
    private final Ln ln;

    public Log() {
        this.ln = new Ln();
    }

    public Log(Ln ln) {
        this.ln = ln;
    }

    @Override
    public double apply(double value, int base) {
        if (!LogarithmicFunction.isValid(value)) {
            if (Double.isNaN(value) || value < 0.0) {
                return Double.NaN;
            } else if (Double.compare(Double.POSITIVE_INFINITY, value) == 0) {
                return Double.POSITIVE_INFINITY;
            } else {
                return Double.NEGATIVE_INFINITY;
            }
        }

        if (!LogarithmicFunction.isValidBase(base)) {
            throw new IllegalArgumentException("Unsupportable base");
        }

        return ln.apply(value) / ln.apply(base);
    }
}
