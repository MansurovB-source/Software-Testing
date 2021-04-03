package trigonometricFunctions;

import static java.lang.Math.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Cos implements TrigonometricFunction {
    private final Sin sin;

    public Cos() {
        sin = new Sin();
    }

    public Cos(Sin sin) {
        this.sin = sin;
    }

    @Override
    public double apply(double value) {
        if (!TrigonometricFunction.isValid(value)) {
            return Double.NaN;
        }
        return sin.apply(value + PI / 2);
    }
}
