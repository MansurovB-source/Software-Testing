package logarithmic;

import logarithmicFunction.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.log;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class LogIntegrationTests implements Constant {
    Log log = new Log();

    @Test
    @DisplayName("Log2: On zero")
    void onZeroLog2() {
        assertEquals(log(0) / log(BASE_2), log.apply(0, BASE_2), PRECISION);
        assertEquals(log(0 + PRECISION) / log(BASE_2), log.apply(0 + PRECISION, BASE_2), PRECISION);
        assertEquals(log(0 - PRECISION) / log(BASE_2), log.apply(0 - PRECISION, BASE_2), PRECISION);
    }

    @Test
    @DisplayName("Log2: On infinity and NaN")
    void nonSupportLog2() {
        assertEquals(log(Double.POSITIVE_INFINITY), log.apply(Double.POSITIVE_INFINITY, BASE_2));
        assertEquals(log(Double.NEGATIVE_INFINITY), log.apply(Double.NEGATIVE_INFINITY, BASE_2));
        assertEquals(log(Double.NaN), log.apply(Double.NaN, BASE_2));
    }

    @ParameterizedTest
    @DisplayName("Log2: On Random")
    @CsvFileSource(resources = "/result_log2.csv")
    void onRandomLog2(double value, double result) {
        assertEquals(result, log.apply(value, BASE_2), PRECISION);
    }

    // ----------------------------------------------------------------------------------------------------------//

    @Test
    @DisplayName("Log3: On zero")
    void onZeroLog3() {
        assertEquals(log(0) / log(BASE_3), log.apply(0, BASE_3), PRECISION);
        assertEquals(log(0 + PRECISION) / log(BASE_3), log.apply(0 + PRECISION, BASE_3), PRECISION);
        assertEquals(log(0 - PRECISION) / log(BASE_3), log.apply(0 - PRECISION, BASE_3), PRECISION);
    }

    @Test
    @DisplayName("Log3: On infinity and NaN")
    void nonSupportLog3() {
        assertEquals(log(Double.POSITIVE_INFINITY), log.apply(Double.POSITIVE_INFINITY, BASE_3));
        assertEquals(log(Double.NEGATIVE_INFINITY), log.apply(Double.NEGATIVE_INFINITY, BASE_3));
        assertEquals(log(Double.NaN), log.apply(Double.NaN, BASE_3));
    }

    @ParameterizedTest
    @DisplayName("Log3: On Random")
    @CsvFileSource(resources = "/result_log3.csv")
    void onRandomLog3(double value, double result) {
        assertEquals(result, log.apply(value, BASE_3), PRECISION);
    }

    // ----------------------------------------------------------------------------------------------------------//

    @Test
    @DisplayName("Log5: On zero")
    void onZeroLog5() {
        assertEquals(log(0) / log(BASE_5), log.apply(0, BASE_5), PRECISION);
        assertEquals(log(0 + PRECISION) / log(BASE_5), log.apply(0 + PRECISION, BASE_5), PRECISION);
        assertEquals(log(0 - PRECISION) / log(BASE_5), log.apply(0 - PRECISION, BASE_5), PRECISION);
    }

    @Test
    @DisplayName("Log5: On infinity and NaN")
    void nonSupportLog5() {
        assertEquals(log(Double.POSITIVE_INFINITY), log.apply(Double.POSITIVE_INFINITY, BASE_5));
        assertEquals(log(Double.NEGATIVE_INFINITY), log.apply(Double.NEGATIVE_INFINITY, BASE_5));
        assertEquals(log(Double.NaN), log.apply(Double.NaN, BASE_5));
    }

    @ParameterizedTest
    @DisplayName("Log5: On Random")
    @CsvFileSource(resources = "/result_log5.csv")
    void onRandomLog5(double value, double result) {
        assertEquals(result, log.apply(value, BASE_5), PRECISION);
    }

    // ----------------------------------------------------------------------------------------------------------//

    @Test
    @DisplayName("Log10: On zero")
    void onZeroLog10() {
        assertEquals(log(0) / log(BASE_10), log.apply(0, BASE_10), PRECISION);
        assertEquals(log(0 + PRECISION) / log(BASE_10), log.apply(0 + PRECISION, BASE_10), PRECISION);
        assertEquals(log(0 - PRECISION) / log(BASE_10), log.apply(0 - PRECISION, BASE_10), PRECISION);
    }

    @Test
    @DisplayName("Log10: On infinity and NaN")
    void nonSupportLog10() {
        assertEquals(log(Double.POSITIVE_INFINITY), log.apply(Double.POSITIVE_INFINITY, BASE_10));
        assertEquals(log(Double.NEGATIVE_INFINITY), log.apply(Double.NEGATIVE_INFINITY, BASE_10));
        assertEquals(log(Double.NaN), log.apply(Double.NaN, BASE_10));
    }

    @ParameterizedTest
    @DisplayName("Log10: On Random")
    @CsvFileSource(resources = "/result_log10.csv")
    void onRandomLog10(double value, double result) {
        assertEquals(result, log.apply(value, BASE_10), PRECISION);
    }

    // ----------------------------------------------------------------------------------------------------------//
}


