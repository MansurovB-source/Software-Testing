package logarithmicFunction;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Log implements LogarithmicFunction {
    private double result;
    private static final Ln ln = new Ln();

    public Log() {
    }

    public Log(double value, double base) {

    }

    @Override
    public double apply(double value, int base) {
        if (!LogarithmicFunction.isValidBase(base)) {
            throw new IllegalArgumentException("Unsupportable base");
        }
        return ln.apply(value) / ln.apply(base);
    }
}
