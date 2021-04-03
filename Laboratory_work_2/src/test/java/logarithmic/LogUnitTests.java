package logarithmic;

import logarithmicFunction.Ln;
import logarithmicFunction.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class LogUnitTests implements Constant {
    Ln ln = Mockito.mock(Ln.class);
    Log log = new Log(ln);

    @ParameterizedTest
    @DisplayName("Log2: Unit test")
    @CsvFileSource(resources = "/result_ln.csv")
    void log2IntegrationTest(double value, double answer) {
        Mockito.when(ln.apply(BASE_2)).thenReturn(0.6931471805599453);
        Mockito.when(ln.apply(value)).thenReturn(answer);

        Assertions.assertEquals(Math.log(value) / Math.log(BASE_2), log.apply(value, BASE_2), PRECISION);
    }

    @ParameterizedTest
    @DisplayName("Log3: Unit test")
    @CsvFileSource(resources = "/result_ln.csv")
    void log3IntegrationTest(double value, double answer) {
        Mockito.when(ln.apply(BASE_3)).thenReturn(1.0986122886681098);
        Mockito.when(ln.apply(value)).thenReturn(answer);

        Assertions.assertEquals(Math.log(value) / Math.log(BASE_3), log.apply(value, BASE_3), PRECISION);
    }

    @ParameterizedTest
    @DisplayName("Log5: Unit test")
    @CsvFileSource(resources = "/result_ln.csv")
    void log5IntegrationTest(double value, double answer) {
        Mockito.when(ln.apply(BASE_5)).thenReturn(1.6094379124341003);
        Mockito.when(ln.apply(value)).thenReturn(answer);

        Assertions.assertEquals(Math.log(value) / Math.log(BASE_5), log.apply(value, BASE_5), PRECISION);
    }

    @ParameterizedTest
    @DisplayName("Log10: Unit test")
    @CsvFileSource(resources = "/result_ln.csv")
    void log10IntegrationTest(double value, double answer) {
        Mockito.when(ln.apply(BASE_10)).thenReturn(2.302585092994046);
        Mockito.when(ln.apply(value)).thenReturn(answer);

        Assertions.assertEquals(Math.log(value) / Math.log(BASE_10), log.apply(value, BASE_10), PRECISION);
    }

}
