package trigonometricFunctions;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Tan implements TrigonometricFunction {
    private final Sin sin;
    private final Cos cos;

    public Tan() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public Tan(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public Tan(Sin sin) {
        this.sin = sin;
        this.cos = new Cos();
    }

    public Tan(Cos cos) {
        this.cos = cos;
        this.sin = new Sin();
    }

    @Override
    public double apply(double value) {
        if (!TrigonometricFunction.isValid(value)) {
            return Double.NaN;
        }

        return sin.apply(value) / cos.apply(value);
    }
}
