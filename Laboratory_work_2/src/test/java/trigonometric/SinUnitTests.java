package trigonometric;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigonometricFunctions.Sin;


/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SinUnitTests implements Constant {
    Sin m_sin = new Sin();

    @Test
    @DisplayName("Boundary points around 0")
    void boundaryOnZero() {
        assertEquals(sin(0), m_sin.apply(0), PRECISION);
        assertEquals(sin(0 - PRECISION), m_sin.apply(0 - PRECISION), PRECISION);
        assertEquals(sin(0 + PRECISION), m_sin.apply(0 + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around PI/2")
    void boundaryOnPIto2() {
        assertEquals(sin(PI / 2), m_sin.apply(PI / 2), PRECISION);
        assertEquals(sin((PI / 2) - PRECISION), m_sin.apply((PI / 2) - PRECISION), PRECISION);
        assertEquals(sin((PI / 2) + PRECISION), m_sin.apply((PI / 2) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around PI")
    void boundaryOnPI() {
        assertEquals(sin(PI), m_sin.apply(PI), PRECISION);
        assertEquals(sin((PI) - PRECISION), m_sin.apply((PI) - PRECISION), PRECISION);
        assertEquals(sin((PI) + PRECISION), m_sin.apply((PI) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around 3PI/2")
    void boundaryOn3PIto2() {
        assertEquals(sin(3 * PI / 2), m_sin.apply(3 * PI / 2), PRECISION);
        assertEquals(sin((3 * PI / 2) - PRECISION), m_sin.apply((3 * PI / 2) - PRECISION), PRECISION);
        assertEquals(sin((3 * PI / 2) + PRECISION), m_sin.apply((3 * PI / 2) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("First Quarter")
    void firstQuarter() {
        assertEquals(sin(PI / 6), m_sin.apply(PI / 6), PRECISION);
        assertEquals(sin(PI / 4), m_sin.apply(PI / 4), PRECISION);
        assertEquals(sin(PI / 3), m_sin.apply(PI / 3), PRECISION);
    }

    @Test
    @DisplayName("Second Quarter")
    void secondQuarter() {
        assertEquals(sin(2 * PI / 3), m_sin.apply(2 * PI / 3), PRECISION);
        assertEquals(sin(3 * PI / 4), m_sin.apply(3 * PI / 4), PRECISION);
        assertEquals(sin(5 * PI / 6), m_sin.apply(5 * PI / 6), PRECISION);
    }

    @Test
    @DisplayName("Third Quarter")
    void thirdQuarter() {
        assertEquals(sin(7 * PI / 6), m_sin.apply(7 * PI / 6), PRECISION);
        assertEquals(sin(5 * PI / 4), m_sin.apply(5 * PI / 4), PRECISION);
        assertEquals(sin(4 * PI / 3), m_sin.apply(4 * PI / 3), PRECISION);
    }

    @Test
    @DisplayName("Forth Quarter")
    void forthQuarter() {
        assertEquals(sin(5 * PI / 3), m_sin.apply(5 * PI / 3), PRECISION);
        assertEquals(sin(7 * PI / 4), m_sin.apply(7 * PI / 4), PRECISION);
        assertEquals(sin(11 * PI / 6), m_sin.apply(11 * PI / 6), PRECISION);
    }

    @Test
    @DisplayName("On infinity and NaN")
    void nonSupport() {
        assertEquals(sin(Double.POSITIVE_INFINITY), m_sin.apply(Double.POSITIVE_INFINITY));
        assertEquals(sin(Double.NEGATIVE_INFINITY), m_sin.apply(Double.NEGATIVE_INFINITY));
        assertEquals(sin(Double.NaN), m_sin.apply(Double.NaN));
    }

    @Test
    @DisplayName("On period")
    void onPeriod() {
        assertEquals(sin(PI / 6 + (2 * PI)), m_sin.apply(PI / 6 + (2 * PI)), PRECISION);
        assertEquals(sin(PI / 6 + (4 * PI)), m_sin.apply(PI / 6 + (4 * PI)), PRECISION);
        assertEquals(sin(PI / 6 + (6 * PI)), m_sin.apply(PI / 6 + (6 * PI)), PRECISION);
        assertEquals(sin(PI / 6 + (8 * PI)), m_sin.apply(PI / 6 + (8 * PI)), PRECISION);
        assertEquals(sin(PI / 6 + (10 * PI)), m_sin.apply(PI / 6 + (10 * PI)), PRECISION);
    }


    @ParameterizedTest
    @DisplayName("On random")
    @CsvFileSource(resources = "/result_sin.csv")
    void onRandom(double value) {
        assertEquals(sin(value), m_sin.apply(value), PRECISION);
    }
}