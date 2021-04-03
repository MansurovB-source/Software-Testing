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
        if (!LogarithmicFunction.isValidBase(base)) {
            throw new IllegalArgumentException("Unsupportable base");
        }

        return ln.apply(value) / ln.apply(base);
    }
}
