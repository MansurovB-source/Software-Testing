package trigonometric;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigonometricFunctions.Sec;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class SecIntegrationTests implements Constant {

    Sec m_sec = new Sec();

    @Test
    @DisplayName("Boundary points around 0")
    void boundaryOnZero() {
        assertEquals(1 / cos(0), m_sec.apply(0), PRECISION);
        assertEquals(1 / cos(0 - PRECISION), m_sec.apply(0 - PRECISION), PRECISION);
        assertEquals(1 / cos(0 + PRECISION), m_sec.apply(0 + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around PI/2")
    void boundaryOnPIto2() {
        assertEquals(Double.POSITIVE_INFINITY, m_sec.apply(PI / 2), PRECISION);
        assertEquals(1 / cos((PI / 2) - PRECISION), m_sec.apply((PI / 2) - PRECISION), PRECISION);
        assertEquals(1 / cos((PI / 2) + PRECISION), m_sec.apply((PI / 2) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around PI")
    void boundaryOnPI() {
        assertEquals(1 / cos(PI), m_sec.apply(PI), PRECISION);
        assertEquals(1 / cos((PI) - PRECISION), m_sec.apply((PI) - PRECISION), PRECISION);
        assertEquals(1 / cos((PI) + PRECISION), m_sec.apply((PI) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around 3PI/2")
    void boundaryOn3PIto2() {
        assertEquals(Double.POSITIVE_INFINITY, m_sec.apply(3 * PI / 2), PRECISION);
        assertEquals(1 / cos((3 * PI / 2) - PRECISION), m_sec.apply((3 * PI / 2) - PRECISION), PRECISION);
        assertEquals(1 / cos((3 * PI / 2) + PRECISION), m_sec.apply((3 * PI / 2) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("First Quarter")
    void firstQuarter() {
        assertEquals(1 / cos(PI / 6), m_sec.apply(PI / 6), PRECISION);
        assertEquals(1 / cos(PI / 4), m_sec.apply(PI / 4), PRECISION);
        assertEquals(1 / cos(PI / 3), m_sec.apply(PI / 3), PRECISION);
    }

    @Test
    @DisplayName("Second Quarter")
    void secondQuarter() {
        assertEquals(1 / cos(2 * PI / 3), m_sec.apply(2 * PI / 3), PRECISION);
        assertEquals(1 / cos(3 * PI / 4), m_sec.apply(3 * PI / 4), PRECISION);
        assertEquals(1 / cos(5 * PI / 6), m_sec.apply(5 * PI / 6), PRECISION);
    }

    @Test
    @DisplayName("Third Quarter")
    void thirdQuarter() {
        assertEquals(1 / cos(7 * PI / 6), m_sec.apply(7 * PI / 6), PRECISION);
        assertEquals(1 / cos(5 * PI / 4), m_sec.apply(5 * PI / 4), PRECISION);
        assertEquals(1 / cos(4 * PI / 3), m_sec.apply(4 * PI / 3), PRECISION);
    }

    @Test
    @DisplayName("Forth Quarter")
    void forthQuarter() {
        assertEquals(1 / cos(5 * PI / 3), m_sec.apply(5 * PI / 3), PRECISION);
        assertEquals(1 / cos(7 * PI / 4), m_sec.apply(7 * PI / 4), PRECISION);
        assertEquals(1 / cos(11 * PI / 6), m_sec.apply(11 * PI / 6), PRECISION);
    }

    @Test
    @DisplayName("On infinity and NaN")
    void nonSupport() {
        assertEquals(1 / cos(Double.POSITIVE_INFINITY), m_sec.apply(Double.POSITIVE_INFINITY));
        assertEquals(1 / cos(Double.NEGATIVE_INFINITY), m_sec.apply(Double.NEGATIVE_INFINITY));
        assertEquals(1 / cos(Double.NaN), m_sec.apply(Double.NaN));
    }

    @Test
    @DisplayName("On period")
    void onPeriod() {
        assertEquals(1 / cos(PI / 6 + (2 * PI)), m_sec.apply(PI / 6 + (2 * PI)), PRECISION);
        assertEquals(1 / cos(PI / 6 + (4 * PI)), m_sec.apply(PI / 6 + (4 * PI)), PRECISION);
        assertEquals(1 / cos(PI / 6 + (6 * PI)), m_sec.apply(PI / 6 + (6 * PI)), PRECISION);
        assertEquals(1 / cos(PI / 6 + (8 * PI)), m_sec.apply(PI / 6 + (8 * PI)), PRECISION);
        assertEquals(1 / cos(PI / 6 + (10 * PI)), m_sec.apply(PI / 6 + (10 * PI)), PRECISION);
    }

    @ParameterizedTest
    @DisplayName("On Random")
    @CsvFileSource(resources = "/result_sec.csv")
    void onRandom(double value, double answer) {
        assertEquals(answer, m_sec.apply(value), PRECISION);
    }
}
