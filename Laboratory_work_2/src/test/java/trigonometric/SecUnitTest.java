package trigonometric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import trigonometricFunctions.CoSec;
import trigonometricFunctions.Cos;
import trigonometricFunctions.Sec;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class SecUnitTest {
    double PRECISION = 0.05;
    Cos cos = Mockito.mock(Cos.class);

    @ParameterizedTest
    @DisplayName("Unit Test")
    @CsvFileSource(resources = "/result_sec.csv")
    void coSecTest(double value, double answer) {
        Sec sec = new Sec(cos);
        Mockito.when(cos.apply(value)).thenReturn(answer);
        Assertions.assertEquals(1 / answer, sec.apply(value), PRECISION);
    }
}
