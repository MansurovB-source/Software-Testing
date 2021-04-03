package trigonometricFunctions;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class CoSec implements TrigonometricFunction {
    private final Sin sin;

    public CoSec() {
        sin = new Sin();
    }

    public CoSec(Sin sin) {
        this.sin = sin;
    }

    @Override
    public double apply(double value) {
        if (!TrigonometricFunction.isValid(value)) {
            return Double.NaN;
        }

        return 1 / sin.apply(value);
    }
}
