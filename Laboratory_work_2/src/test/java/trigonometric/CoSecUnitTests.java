package trigonometric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import trigonometricFunctions.CoSec;
import trigonometricFunctions.Sin;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class CoSecUnitTests {
    double PRECISION = 0.05;
    Sin sin = Mockito.mock(Sin.class);

    @ParameterizedTest
    @DisplayName("Unit Test")
    @CsvFileSource(resources = "/result_coSec.csv")
    void coSecTest(double value, double answer) {
        CoSec coSec = new CoSec(sin);
        Mockito.when(sin.apply(value)).thenReturn(answer);
        Assertions.assertEquals(1 / answer, coSec.apply(value), PRECISION);
    }
}
