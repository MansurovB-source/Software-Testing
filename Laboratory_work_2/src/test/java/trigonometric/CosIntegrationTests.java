package trigonometric;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigonometricFunctions.Cos;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class CosIntegrationTests {
    double PRECISION = 0.05;
    Cos m_cos = new Cos();

    @Test
    @DisplayName("Boundary points around 0")
    void boundaryOnZero() {
        assertEquals(cos(0), m_cos.apply(0), PRECISION);
        assertEquals(cos(0 - PRECISION), m_cos.apply(0 - PRECISION), PRECISION);
        assertEquals(cos(0 + PRECISION), m_cos.apply(0 + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around PI/2")
    void boundaryOnPIto2() {
        assertEquals(cos(PI / 2), m_cos.apply(PI / 2), PRECISION);
        assertEquals(cos((PI / 2) - PRECISION), m_cos.apply((PI / 2) - PRECISION), PRECISION);
        assertEquals(cos((PI / 2) + PRECISION), m_cos.apply((PI / 2) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around PI")
    void boundaryOnPI() {
        assertEquals(cos(PI), m_cos.apply(PI), PRECISION);
        assertEquals(cos((PI) - PRECISION), m_cos.apply((PI) - PRECISION), PRECISION);
        assertEquals(cos((PI) + PRECISION), m_cos.apply((PI) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("Boundary points around 3PI/2")
    void boundaryOn3PIto2() {
        assertEquals(cos(3 * PI / 2), m_cos.apply(3 * PI / 2), PRECISION);
        assertEquals(cos((3 * PI / 2) - PRECISION), m_cos.apply((3 * PI / 2) - PRECISION), PRECISION);
        assertEquals(cos((3 * PI / 2) + PRECISION), m_cos.apply((3 * PI / 2) + PRECISION), PRECISION);
    }

    @Test
    @DisplayName("First Quarter")
    void firstQuarter() {
        assertEquals(cos(PI / 6), m_cos.apply(PI / 6), PRECISION);
        assertEquals(cos(PI / 4), m_cos.apply(PI / 4), PRECISION);
        assertEquals(cos(PI / 3), m_cos.apply(PI / 3), PRECISION);
    }

    @Test
    @DisplayName("Second Quarter")
    void secondQuarter() {
        assertEquals(cos(2 * PI / 3), m_cos.apply(2 * PI / 3), PRECISION);
        assertEquals(cos(3 * PI / 4), m_cos.apply(3 * PI / 4), PRECISION);
        assertEquals(cos(5 * PI / 6), m_cos.apply(5 * PI / 6), PRECISION);
    }

    @Test
    @DisplayName("Third Quarter")
    void thirdQuarter() {
        assertEquals(cos(7 * PI / 6), m_cos.apply(7 * PI / 6), PRECISION);
        assertEquals(cos(5 * PI / 4), m_cos.apply(5 * PI / 4), PRECISION);
        assertEquals(cos(4 * PI / 3), m_cos.apply(4 * PI / 3), PRECISION);
    }

    @Test
    @DisplayName("Forth Quarter")
    void forthQuarter() {
        assertEquals(cos(5 * PI / 3), m_cos.apply(5 * PI / 3), PRECISION);
        assertEquals(cos(7 * PI / 4), m_cos.apply(7 * PI / 4), PRECISION);
        assertEquals(cos(11 * PI / 6), m_cos.apply(11 * PI / 6), PRECISION);
    }

    @Test
    @DisplayName("On infinity and NaN")
    void nonSupport() {
        assertEquals(cos(Double.POSITIVE_INFINITY), m_cos.apply(Double.POSITIVE_INFINITY));
        assertEquals(cos(Double.NEGATIVE_INFINITY), m_cos.apply(Double.NEGATIVE_INFINITY));
        assertEquals(cos(Double.NaN), m_cos.apply(Double.NaN));
    }

    @Test
    @DisplayName("On period")
    void onPeriod() {
        assertEquals(cos(PI / 6 + (2 * PI)), m_cos.apply(PI / 6 + (2 * PI)), PRECISION);
        assertEquals(cos(PI / 6 + (4 * PI)), m_cos.apply(PI / 6 + (4 * PI)), PRECISION);
        assertEquals(cos(PI / 6 + (6 * PI)), m_cos.apply(PI / 6 + (6 * PI)), PRECISION);
        assertEquals(cos(PI / 6 + (8 * PI)), m_cos.apply(PI / 6 + (8 * PI)), PRECISION);
        assertEquals(cos(PI / 6 + (10 * PI)), m_cos.apply(PI / 6 + (10 * PI)), PRECISION);
    }

    @ParameterizedTest
    @DisplayName("On Random")
    @CsvFileSource(resources = "/result_cos.csv")
    void onRandom(double value) {
        assertEquals(cos(value), m_cos.apply(value), PRECISION);
    }
}
