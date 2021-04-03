package trigonometric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import trigonometricFunctions.Cos;
import trigonometricFunctions.Sin;
import trigonometricFunctions.Tan;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class TanUnitTests implements Constant {
    Sin sin = Mockito.mock(Sin.class);
    Cos cos = Mockito.mock(Cos.class);

    @ParameterizedTest
    @DisplayName("mock on sin")
    @CsvFileSource(resources = "/result_sin.csv")
    void onSinMock(double value, double answer) {
        Tan tan = new Tan(sin);
        Mockito.when(sin.apply(value)).thenReturn(answer);
        Assertions.assertEquals(Math.tan(value), tan.apply(value), PRECISION);
    }

    @ParameterizedTest
    @DisplayName("mock on cos")
    @CsvFileSource(resources = "/result_cos.csv")
    void onCosMock(double value, double answer) {
        Tan tan = new Tan(cos);
        Mockito.when(cos.apply(value)).thenReturn(answer);
        Assertions.assertEquals(Math.tan(value), tan.apply(value), PRECISION);
    }

}
