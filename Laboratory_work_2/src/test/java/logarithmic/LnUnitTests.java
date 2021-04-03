package logarithmic;

import logarithmicFunction.Ln;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static java.lang.Math.log;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LnUnitTests implements Constant {
    Ln ln = new Ln();

    @Test
    @DisplayName("On zero")
    void onZero() {
        assertEquals(log(0), ln.apply(0), PRECISION);
        assertEquals(log(0 + PRECISION), ln.apply(0 + PRECISION), PRECISION);
        assertEquals(log(0 - PRECISION), ln.apply(0 - PRECISION), PRECISION);
    }

    @Test
    @DisplayName("On infinity and NaN")
    void nonSupport() {
        assertEquals(log(Double.POSITIVE_INFINITY), ln.apply(Double.POSITIVE_INFINITY));
        assertEquals(log(Double.NEGATIVE_INFINITY), ln.apply(Double.NEGATIVE_INFINITY));
        assertEquals(log(Double.NaN), ln.apply(Double.NaN));
    }

    @ParameterizedTest
    @DisplayName("On Random")
    @CsvFileSource(resources = "/result_ln.csv")
    void onRandom(double value, double result) {
        assertEquals(result, ln.apply(value), PRECISION);
    }
}
