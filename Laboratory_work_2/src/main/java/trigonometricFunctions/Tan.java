package trigonometricFunctions;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Tan implements TrigonometricFunction {
    private double result;
    private static final Sin sin = new Sin();
    private static final Cos cos = new Cos();

    public Tan() {
    }

    public Tan(double value) {
        result = apply(value);
    }

    @Override
    public double apply(double value) {
        if (!TrigonometricFunction.isValid(value)) {
            return Double.NaN;
        }
        return sin.apply(value) / cos.apply(value);
    }

    public double getResult() {
        return result;
    }
}
