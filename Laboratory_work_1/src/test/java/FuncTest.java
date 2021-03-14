import Function.TaylorSec;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

public class FuncTest {
    private static final double PI = Math.PI;

    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void onZero() {
        System.out.println("0");
        double value = 0;
        Assert.assertEquals(1.0 / Math.cos(value), TaylorSec.sec(value), TaylorSec.epsilon);
    }

    @Test
    public void boundaryOnZero() {
        System.out.println("0 +- e");
        double value_1 = 0 + TaylorSec.epsilon;
        double value_2 = 0 - TaylorSec.epsilon;
        Assert.assertEquals(1.0 / Math.cos(value_1), TaylorSec.sec(value_1), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(value_2), TaylorSec.sec(value_2), TaylorSec.epsilon);
    }
    //-------------------------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void on2Pi() {
        System.out.println("2PI");
        double value = 2 * PI;
        Assert.assertEquals(1.0 / Math.cos(value), TaylorSec.sec(value), TaylorSec.epsilon);
    }

    @Test
    public void boundaryOn2Pi() {
        System.out.println("2PI +- e");
        double value_1 = 2 * PI + TaylorSec.epsilon;
        double value_2 = 2 * PI - TaylorSec.epsilon;
        Assert.assertEquals(1.0 / Math.cos(value_1), TaylorSec.sec(value_1), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(value_2), TaylorSec.sec(value_2), TaylorSec.epsilon);
    }
    //-------------------------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void onPi() {
        System.out.println("PI");
        double value = PI;
        Assert.assertEquals(1.0 / Math.cos(value), TaylorSec.sec(value), TaylorSec.epsilon);
    }

    @Test
    public void boundaryOnPi() {
        System.out.println("PI +- e");
        double value_1 = PI + TaylorSec.epsilon;
        double value_2 = PI - TaylorSec.epsilon;
        Assert.assertEquals(1.0 / Math.cos(value_1), TaylorSec.sec(value_1), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(value_2), TaylorSec.sec(value_2), TaylorSec.epsilon);
    }
    //-------------------------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void onPiTo2() {
        System.out.println("PI / 2");
        double value = PI / 2;
        Assert.assertEquals(Double.POSITIVE_INFINITY, TaylorSec.sec(value), TaylorSec.epsilon);
    }

    @Test
    public void boundaryOnPiTo2() {
        System.out.println("PI / 2 +- e");
        Assert.assertEquals(1.0 / Math.cos(PI / 2 + TaylorSec.epsilon), TaylorSec.sec(PI / 2 + TaylorSec.epsilon), TaylorSec.epsilon + 1E-3);
        Assert.assertEquals(1.0 / Math.cos(PI / 2 - TaylorSec.epsilon), TaylorSec.sec(PI / 2 - TaylorSec.epsilon), TaylorSec.epsilon + 1E-3);
    }
    //-------------------------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void on3PiTo2() {
        System.out.println("3PI / 2");
        double value = 3 * PI / 2;
        Assert.assertEquals(Double.NEGATIVE_INFINITY, TaylorSec.sec(value), TaylorSec.epsilon);
    }

    @Test
    public void boundaryOn3PiTo2() {
        System.out.println("3PI / 2 +- e");
        double value_1 = 3 * PI / 2 + TaylorSec.epsilon;
        double value_2 = 3 * PI / 2 - TaylorSec.epsilon;
        System.out.println(1.0 / Math.cos(value_1) - TaylorSec.sec(value_1));
        Assert.assertEquals(1.0 / Math.cos(value_1), TaylorSec.sec(value_1), 0.01);
        Assert.assertEquals(1.0 / Math.cos(value_2), TaylorSec.sec(value_2), 0.01);
    }
    //-------------------------------------------------------------------------------------------------------------//


    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void onPositiveInfinity() {
        System.out.println("∞");
        Assert.assertEquals(Double.NaN, TaylorSec.sec(Double.POSITIVE_INFINITY), TaylorSec.epsilon);
    }

    @Test
    public void onNegativeInfinity() {
        System.out.println("-∞");
        Assert.assertEquals(Double.NaN, TaylorSec.sec(Double.NEGATIVE_INFINITY), TaylorSec.epsilon);
    }
    //-------------------------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void onNaN() {
        System.out.println("NaN");
        Assert.assertEquals(Double.NaN, TaylorSec.sec(Double.NEGATIVE_INFINITY), TaylorSec.epsilon);
    }
    //-------------------------------------------------------------------------------------------------------------//


    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void firstQuarter() {
        Assert.assertEquals(1.0 / Math.cos(PI / 3), TaylorSec.sec(PI / 3), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(PI / 4), TaylorSec.sec(PI / 4), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(PI / 6), TaylorSec.sec(PI / 6), TaylorSec.epsilon);
    }
    //-------------------------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void secondQuarter() {
        Assert.assertEquals(1.0 / Math.cos(PI / 2 + PI / 3), TaylorSec.sec(PI / 2 + PI / 3), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(PI / 2 + PI / 4), TaylorSec.sec(PI / 2 + PI / 4), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(PI / 2 + PI / 6), TaylorSec.sec(PI / 2 + PI / 6), TaylorSec.epsilon);
    }
    //-------------------------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void thirdQuarter() {
        Assert.assertEquals(1.0 / Math.cos(PI + PI / 3), TaylorSec.sec(PI + PI / 3), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(PI + PI / 4), TaylorSec.sec(PI + PI / 4), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(PI + PI / 6), TaylorSec.sec(PI + PI / 6), TaylorSec.epsilon);
    }
    //-------------------------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------------------------//
    @Test
    public void forthQuarter() {
        Assert.assertEquals(1.0 / Math.cos(3 * PI / 2 + PI / 3), TaylorSec.sec(3 * PI / 2 + PI / 3), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(3 * PI / 2 + PI / 4), TaylorSec.sec(3 * PI / 2 + PI / 4), TaylorSec.epsilon);
        Assert.assertEquals(1.0 / Math.cos(3 * PI / 2 + PI / 6), TaylorSec.sec(3 * PI / 2 + PI / 6), TaylorSec.epsilon);
    }
    //-------------------------------------------------------------------------------------------------------------//

//    @Test
//    public void onZero() {
//        System.out.println("0");
//        Assert.assertEquals((double) (1 / Math.cos(0)), TaylorSec.sec(0), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void onPiTo6() {
//        System.out.println("Pi/6");
//        Assert.assertEquals((double) (1 / Math.cos(Math.PI / 6)), TaylorSec.sec(Math.PI / 6), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void onMinusPiTo6() {
//        System.out.println("-Pi/6");
//        Assert.assertEquals((double) (1 / Math.cos(-Math.PI / 6)), TaylorSec.sec(-Math.PI / 6), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void onPiTo4() {
//        System.out.println("Pi/4");
//        Assert.assertEquals((double) (1 / Math.cos(Math.PI / 4)), TaylorSec.sec(Math.PI / 4), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void onMinusPiTo4() {
//        System.out.println("-Pi/4");
//        Assert.assertEquals((double) (1 / Math.cos(-Math.PI / 4)), TaylorSec.sec(-Math.PI / 4), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void onPiTo3() {
//        System.out.println("Pi/3");
//        Assert.assertEquals((double) (1 / Math.cos(Math.PI / 3)), TaylorSec.sec(Math.PI / 3), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void onMinusPiTo3() {
//        System.out.println("-Pi/3");
//        Assert.assertEquals((double) (1 / Math.cos(-Math.PI / 3)), TaylorSec.sec(-Math.PI / 3), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void onPi() {
//        System.out.println("Pi");
//        Assert.assertEquals((double) (1 / Math.cos(Math.PI)), TaylorSec.sec(Math.PI), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void onMinusPi() {
//        System.out.println("-Pi");
//        Assert.assertEquals((double) (1 / Math.cos(-Math.PI)), TaylorSec.sec(-Math.PI), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void on3PiTo2() {
//        System.out.println("3Pi/4");
//        Assert.assertEquals((double) (1 / Math.cos(3 * Math.PI / 4)), TaylorSec.sec(3 * Math.PI / 4), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void onMinus3PiTo2() {
//        System.out.println("-3Pi/4");
//        Assert.assertEquals((double) (1 / Math.cos(-3 * Math.PI / 4)), TaylorSec.sec(-3 * Math.PI / 4), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void on2Pi() {
//        System.out.println("2Pi");
//        Assert.assertEquals((double) (1 / Math.cos(2 * Math.PI)), TaylorSec.sec(2 * Math.PI), TaylorSec.epsilon);
//    }
//
//    @Test
//    public void onMinus2Pi() {
//        System.out.println("-2Pi");
//        Assert.assertEquals((double) (1 / Math.cos(2 * Math.PI)), TaylorSec.sec(2 * Math.PI), TaylorSec.epsilon);
//    }


}
