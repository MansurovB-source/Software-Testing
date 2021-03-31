package trigonometricFunctions;

import static java.lang.Math.PI;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Cos implements TrigonometricFunction {
    private double result;
    private static final Sin sin = new Sin();

    public Cos() {
    }

    public Cos(double value) {
        result = apply(value);
    }

    public double getResult() {
        return result;
    }

    @Override
    public double apply(double value) {
        return sin.apply(value + PI / 2);
    }
}
