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
    private Cos cos;
    private CoSec coSec;
    private Sec sec;
    private Sin sin;
    private Tan tan;

    private Ln ln;
    private Log log;

    public MainFunction() {
        this.cos = new Cos();
        this.coSec = new CoSec();
        this.sec = new Sec();
        this.sin = new Sin();
        this.tan = new Tan();
        this.ln = new Ln();
        this.log = new Log();
    }

    public MainFunction(Cos cos, CoSec coSec, Sec sec, Sin sin, Tan tan, Ln ln, Log log) {
        this.cos = cos;
        this.coSec = coSec;
        this.sec = sec;
        this.sin = sin;
        this.tan = tan;
        this.ln = ln;
        this.log = log;
    }

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
        System.out.println(mainFunction.apply(3.4));
    }

    public Cos getCos() {
        return cos;
    }

    public CoSec getCoSec() {
        return coSec;
    }

    public Sec getSec() {
        return sec;
    }

    public Sin getSin() {
        return sin;
    }

    public Tan getTan() {
        return tan;
    }

    public Ln getLn() {
        return ln;
    }

    public Log getLog() {
        return log;
    }
}
