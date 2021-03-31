package trigonometricFunctions;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Sec implements TrigonometricFunction {
    private double result;
    private static final Cos cos = new Cos();

    public Sec(double value) {
        this.result = apply(value);
    }

    @Override
    public double apply(double value) {
        return 1 / cos.apply(value);
    }

    public double getResult() {
        return result;
    }
}
