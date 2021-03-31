package mainFunction;

import logarithmicFunction.Ln;
import logarithmicFunction.Log;
import trigonometricFunctions.*;

import static java.lang.Math.pow;


/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class MainFunction {
    private Cos cos = new Cos();
    private CoSec coSec = new CoSec();
    private Sec sec = new Sec();
    private Sin sin = new Sin();
    private Tan tan = new Tan();

    private Ln ln = new Ln();
    private Log log = new Log();

    public double apply(double value) {
        if (value <= 0) {
            return (((pow(coSec.apply(value) - coSec.apply(value), 3)) - cos.apply(value)) / (pow(sin.apply(value), 2)))
                    * (tan.apply(value) + sec.apply(value));
        } else {
            return ((((log.apply(value, 2) - log.apply(value, 2)) / log.apply(value, 10)) / log.apply(value, 3)) + log.apply(value, 3))
                    + (pow((log.apply(value, 10)) / (log.apply(value, 5) * (ln.apply(value) - log.apply(value, 5))), 3));
        }
    }

    public static void main(String[] args) {
        MainFunction mainFunction = new MainFunction();
        System.out.println(mainFunction.apply(-4));
    }
}
