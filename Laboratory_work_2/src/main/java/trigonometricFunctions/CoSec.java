package trigonometricFunctions;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class CoSec implements TrigonometricFunction {
    private double result;
    private static final Sin sin = new Sin();

    public CoSec() {
    }

    public CoSec(double value) {
        this.result = apply(value);
    }

    @Override
    public double apply(double value) {
        if (!TrigonometricFunction.isValid(value)) {
            return Double.NaN;
        }
        return 1 / sin.apply(value);
    }

    public double getResult() {
        return result;
    }
}
