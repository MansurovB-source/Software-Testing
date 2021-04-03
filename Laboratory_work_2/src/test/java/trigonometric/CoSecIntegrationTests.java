package trigonometric;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigonometricFunctions.CoSec;

import static java.lang.Math.PI;
import static java.lang.Math.sin;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class CoSecIntegrationTests implements Constant {
    CoSec m_coSec = new CoSec();

    @Test
    @DisplayName("Boundary points around 0")
    void boundaryOnZero() {
        assertEquals(1 / sin(0), m_coSec.apply(0), PRECISION);
        assertEquals(1 / sin(0 - PRECISION), m_coSec.apply(0 - PRECISION), PRECISION);
        assertEquals(1 / sin(0 + PRECISION), m_coSec.apply(0 + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around PI/2")
    void boundaryOnPIto2() {
        assertEquals(1 / sin(PI / 2), m_coSec.apply(PI / 2), PRECISION);
        assertEquals(1 / sin((PI / 2) - PRECISION), m_coSec.apply((PI / 2) - PRECISION), PRECISION);
        assertEquals(1 / sin((PI / 2) + PRECISION), m_coSec.apply((PI / 2) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around PI")
    void boundaryOnPI() {
        assertEquals(Double.POSITIVE_INFINITY, m_coSec.apply(PI), PRECISION);
        assertEquals(1 / sin((PI) - PRECISION), m_coSec.apply((PI) - PRECISION), PRECISION);
        assertEquals(1 / sin((PI) + PRECISION), m_coSec.apply((PI) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around 3PI/2")
    void boundaryOn3PIto2() {
        assertEquals(1 / sin(3 * PI / 2), m_coSec.apply(3 * PI / 2), PRECISION);
        assertEquals(1 / sin((3 * PI / 2) - PRECISION), m_coSec.apply((3 * PI / 2) - PRECISION), PRECISION);
        assertEquals(1 / sin((3 * PI / 2) + PRECISION), m_coSec.apply((3 * PI / 2) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("First Quarter")
    void firstQuarter() {
        assertEquals(1 / sin(PI / 6), m_coSec.apply(PI / 6), PRECISION);
        assertEquals(1 / sin(PI / 4), m_coSec.apply(PI / 4), PRECISION);
        assertEquals(1 / sin(PI / 3), m_coSec.apply(PI / 3), PRECISION);
    }

    @Test
    @DisplayName("Second Quarter")
    void secondQuarter() {
        assertEquals(1 / sin(2 * PI / 3), m_coSec.apply(2 * PI / 3), PRECISION);
        assertEquals(1 / sin(3 * PI / 4), m_coSec.apply(3 * PI / 4), PRECISION);
        assertEquals(1 / sin(5 * PI / 6), m_coSec.apply(5 * PI / 6), PRECISION);
    }

    @Test
    @DisplayName("Third Quarter")
    void thirdQuarter() {
        assertEquals(1 / sin(7 * PI / 6), m_coSec.apply(7 * PI / 6), PRECISION);
        assertEquals(1 / sin(5 * PI / 4), m_coSec.apply(5 * PI / 4), PRECISION);
        assertEquals(1 / sin(4 * PI / 3), m_coSec.apply(4 * PI / 3), PRECISION);
    }

    @Test
    @DisplayName("Forth Quarter")
    void forthQuarter() {
        assertEquals(1 / sin(5 * PI / 3), m_coSec.apply(5 * PI / 3), PRECISION);
        assertEquals(1 / sin(7 * PI / 4), m_coSec.apply(7 * PI / 4), PRECISION);
        assertEquals(1 / sin(11 * PI / 6), m_coSec.apply(11 * PI / 6), PRECISION);
    }

    @Test
    @DisplayName("On infinity and NaN")
    void nonSupport() {
        assertEquals(1 / sin(Double.POSITIVE_INFINITY), m_coSec.apply(Double.POSITIVE_INFINITY));
        assertEquals(1 / sin(Double.NEGATIVE_INFINITY), m_coSec.apply(Double.NEGATIVE_INFINITY));
        assertEquals(1 / sin(Double.NaN), m_coSec.apply(Double.NaN));
    }

    @Test
    @DisplayName("On period")
    void onPeriod() {
        assertEquals(1 / sin(PI / 6 + (2 * PI)), m_coSec.apply(PI / 6 + (2 * PI)), PRECISION);
        assertEquals(1 / sin(PI / 6 + (4 * PI)), m_coSec.apply(PI / 6 + (4 * PI)), PRECISION);
        assertEquals(1 / sin(PI / 6 + (6 * PI)), m_coSec.apply(PI / 6 + (6 * PI)), PRECISION);
        assertEquals(1 / sin(PI / 6 + (8 * PI)), m_coSec.apply(PI / 6 + (8 * PI)), PRECISION);
        assertEquals(1 / sin(PI / 6 + (10 * PI)), m_coSec.apply(PI / 6 + (10 * PI)), PRECISION);
    }

    @ParameterizedTest
    @DisplayName("Unit Test")
    @CsvFileSource(resources = "/result_coSec.csv")
    void onRandom(double value, double answer) {
        assertEquals(answer, m_coSec.apply(value), PRECISION);
    }
}
