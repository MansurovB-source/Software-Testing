package mainFunction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class MainFuncIntegrationTests {
    double PRECISION = 0.001;
    MainFunction mainFunction = new MainFunction();

    @Test
    @DisplayName("On Nan and Infinity")
    void nonSupport() {
        Assertions.assertEquals(Double.NaN, mainFunction.apply(Double.NaN));
        Assertions.assertEquals(Double.NaN, mainFunction.apply(Double.NEGATIVE_INFINITY));
        Assertions.assertEquals(Double.NaN, mainFunction.apply(Double.POSITIVE_INFINITY));
    }

    @Test
    @DisplayName("on Random Points")
    void onRandom() {
        Assertions.assertEquals(4.54559, mainFunction.apply(3.4), PRECISION);
        Assertions.assertEquals(2.81511, mainFunction.apply(15.9), PRECISION);
        Assertions.assertEquals(3.59704608, mainFunction.apply(46), PRECISION);

        Assertions.assertEquals(-2.00238, mainFunction.apply(-99), PRECISION);
        Assertions.assertEquals(-18.2308, mainFunction.apply(-12.3), PRECISION);
        Assertions.assertEquals(-0.562041, mainFunction.apply(-8.63), PRECISION);

    }
}
