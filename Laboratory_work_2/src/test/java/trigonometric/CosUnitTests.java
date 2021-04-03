package trigonometric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import trigonometricFunctions.Cos;
import trigonometricFunctions.Sin;

import static java.lang.Math.PI;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class CosUnitTests {
    double PRECISION = 0.05;
    Sin sinMock = Mockito.mock(Sin.class);
    Cos cos = new Cos(sinMock);

    @ParameterizedTest
    @DisplayName("Unit Test")
    @CsvFileSource(resources = "/result_sin.csv")
    void cosTest(double value, double answer) {
        Mockito.when(sinMock.apply(value)).thenReturn(answer);
        Assertions.assertEquals(Math.cos(value - PI / 2), cos.apply(value - PI / 2), PRECISION);
    }
}
