import Function.TaylorSec;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

public class FuncTest {

    @Test
    public void onZero() {
        System.out.println("0");
        Assert.assertEquals((double) (1 / Math.cos(0)), TaylorSec.sec(0), TaylorSec.epsilon);
    }

    @Test
    public void onPiTo6() {
        System.out.println("Pi/6");
        Assert.assertEquals((double) (1 / Math.cos(Math.PI / 6)), TaylorSec.sec(Math.PI / 6), TaylorSec.epsilon);
    }

    @Test
    public void onMinusPiTo6() {
        System.out.println("-Pi/6");
        Assert.assertEquals((double) (1 / Math.cos(-Math.PI / 6)), TaylorSec.sec(-Math.PI / 6), TaylorSec.epsilon);
    }

    @Test
    public void onPiTo4() {
        System.out.println("Pi/4");
        Assert.assertEquals((double) (1 / Math.cos(Math.PI / 4)), TaylorSec.sec(Math.PI / 4), TaylorSec.epsilon);
    }

    @Test
    public void onMinusPiTo4() {
        System.out.println("-Pi/4");
        Assert.assertEquals((double) (1 / Math.cos(-Math.PI / 4)), TaylorSec.sec(-Math.PI / 4), TaylorSec.epsilon);
    }

    @Test
    public void onPiTo3() {
        System.out.println("Pi/3");
        Assert.assertEquals((double) (1 / Math.cos(Math.PI / 3)), TaylorSec.sec(Math.PI / 3), TaylorSec.epsilon);
    }

    @Test
    public void onMinusPiTo3() {
        System.out.println("-Pi/3");
        Assert.assertEquals((double) (1 / Math.cos(-Math.PI / 3)), TaylorSec.sec(-Math.PI / 3), TaylorSec.epsilon);
    }

    @Test
    public void onPi() {
        System.out.println("Pi");
        Assert.assertEquals((double) (1 / Math.cos(Math.PI)), TaylorSec.sec(Math.PI), TaylorSec.epsilon);
    }

    @Test
    public void onMinusPi() {
        System.out.println("-Pi");
        Assert.assertEquals((double) (1 / Math.cos(-Math.PI)), TaylorSec.sec(-Math.PI), TaylorSec.epsilon);
    }

    @Test
    public void on3PiTo2() {
        System.out.println("3Pi/4");
        Assert.assertEquals((double) (1 / Math.cos(3 * Math.PI / 4)), TaylorSec.sec(3 * Math.PI / 4), TaylorSec.epsilon);
    }

    @Test
    public void onMinus3PiTo2() {
        System.out.println("-3Pi/4");
        Assert.assertEquals((double) (1 / Math.cos(-3 * Math.PI / 4)), TaylorSec.sec(-3 * Math.PI / 4), TaylorSec.epsilon);
    }

    @Test
    public void on2Pi() {
        System.out.println("2Pi");
        Assert.assertEquals((double) (1 / Math.cos(2 * Math.PI)), TaylorSec.sec(2 * Math.PI), TaylorSec.epsilon);
    }

    @Test
    public void onMinus2Pi() {
        System.out.println("-2Pi");
        Assert.assertEquals((double) (1 / Math.cos(2 * Math.PI)), TaylorSec.sec(2 * Math.PI), TaylorSec.epsilon);
    }


}
