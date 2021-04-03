package trigonometric;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigonometricFunctions.Tan;

import static java.lang.Math.PI;
import static java.lang.Math.tan;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class TanIntegrationTests {
    double PRECISION = 0.05;
    Tan m_tan = new Tan();

    @Test
    @DisplayName("Boundary points around 0")
    void boundaryOnZero() {
        assertEquals(tan(0), m_tan.apply(0), PRECISION);
        assertEquals(tan(0 - PRECISION), m_tan.apply(0 - PRECISION), PRECISION);
        assertEquals(tan(0 + PRECISION), m_tan.apply(0 + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around PI/2")
    void boundaryOnPIto2() {
        assertEquals(Double.POSITIVE_INFINITY, m_tan.apply(PI / 2), PRECISION);
        assertEquals(tan((PI / 2) - PRECISION), m_tan.apply((PI / 2) - PRECISION), PRECISION);
        assertEquals(tan((PI / 2) + PRECISION), m_tan.apply((PI / 2) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around PI")
    void boundaryOnPI() {
        assertEquals(tan(PI), m_tan.apply(PI), PRECISION);
        assertEquals(tan((PI) - PRECISION), m_tan.apply((PI) - PRECISION), PRECISION);
        assertEquals(tan((PI) + PRECISION), m_tan.apply((PI) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around 3PI/2")
    void boundaryOn3PIto2() {
        assertEquals(Double.NEGATIVE_INFINITY, m_tan.apply(3 * PI / 2), PRECISION);
        System.out.println(tan((3 * PI / 2) - PRECISION));
        System.out.println(m_tan.apply((3 * PI / 2) - PRECISION));
        assertEquals(tan((3 * PI / 2) - PRECISION), m_tan.apply((3 * PI / 2) - PRECISION), PRECISION);
        assertEquals(tan((3 * PI / 2) + PRECISION), m_tan.apply((3 * PI / 2) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("First Quarter")
    void firstQuarter() {
        assertEquals(tan(PI / 6), m_tan.apply(PI / 6), PRECISION);
        assertEquals(tan(PI / 4), m_tan.apply(PI / 4), PRECISION);
        assertEquals(tan(PI / 3), m_tan.apply(PI / 3), PRECISION);
    }

    @Test
    @DisplayName("Second Quarter")
    void secondQuarter() {
        assertEquals(tan(2 * PI / 3), m_tan.apply(2 * PI / 3), PRECISION);
        assertEquals(tan(3 * PI / 4), m_tan.apply(3 * PI / 4), PRECISION);
        assertEquals(tan(5 * PI / 6), m_tan.apply(5 * PI / 6), PRECISION);
    }

    @Test
    @DisplayName("Third Quarter")
    void thirdQuarter() {
        assertEquals(tan(7 * PI / 6), m_tan.apply(7 * PI / 6), PRECISION);
        assertEquals(tan(5 * PI / 4), m_tan.apply(5 * PI / 4), PRECISION);
        assertEquals(tan(4 * PI / 3), m_tan.apply(4 * PI / 3), PRECISION);
    }

    @Test
    @DisplayName("Forth Quarter")
    void forthQuarter() {
        assertEquals(tan(5 * PI / 3), m_tan.apply(5 * PI / 3), PRECISION);
        assertEquals(tan(7 * PI / 4), m_tan.apply(7 * PI / 4), PRECISION);
        assertEquals(tan(11 * PI / 6), m_tan.apply(11 * PI / 6), PRECISION);
    }

    @Test
    @DisplayName("On infinity and NaN")
    void nonSupport() {
        assertEquals(tan(Double.POSITIVE_INFINITY), m_tan.apply(Double.POSITIVE_INFINITY));
        assertEquals(tan(Double.NEGATIVE_INFINITY), m_tan.apply(Double.NEGATIVE_INFINITY));
        assertEquals(tan(Double.NaN), m_tan.apply(Double.NaN));
    }

    @Test
    @DisplayName("On period")
    void onPeriod() {
        assertEquals(tan(PI / 6 + (PI)), m_tan.apply(PI / 6 + (PI)), PRECISION);
        assertEquals(tan(PI / 6 + (2 * PI)), m_tan.apply(PI / 6 + (2 * PI)), PRECISION);
        assertEquals(tan(PI / 6 + (3 * PI)), m_tan.apply(PI / 6 + (3 * PI)), PRECISION);
        assertEquals(tan(PI / 6 + (4 * PI)), m_tan.apply(PI / 6 + (4 * PI)), PRECISION);
        assertEquals(tan(PI / 6 + (5 * PI)), m_tan.apply(PI / 6 + (5 * PI)), PRECISION);
    }

    @ParameterizedTest
    @DisplayName("On Random")
    @CsvFileSource(resources = "/result_tan.csv")
    void onRandom(double value, double answer) {
        assertEquals(answer, m_tan.apply(value), PRECISION);
    }
}
