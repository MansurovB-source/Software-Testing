import Domain.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class DomainTest {

    //Checking that after the destruction of inhabited planets Jeltz will be annoyed
    @Test
    public void test_1() {
        Planet planet = new Planet(PlanetState.NOTDESTOYED, PlanetPopulation.UNINHABITED);
        planet.destroy();
        planet.populate();
        VogonJeltz jeltz = new VogonJeltz(JeltzState.NORMAL);
        jeltz.toBeAnnoyed(planet);
        Assert.assertEquals(JeltzState.ANNOYED, jeltz.getJeltzState());
    }

    //Check that after someone told him that they were wrong he would yell and he would feel better
    @Test
    public void test_2() {
        Entity entity = new Entity(EntityState.NORMAL);
        entity.makeMistake();
        VogonJeltz jeltz = new VogonJeltz(JeltzState.ANNOYED);
        jeltz.shout(entity);
        Assert.assertEquals(JeltzState.INAGOODMOOD, jeltz.getJeltzState());
    }

    //Check that after he plopped down in the chair with all his strength, in the hope that it
    // would break, and he would be able to get genuinely angry
    @Test
    public void test_3() {
        Armchair armchair = new Armchair(ArmchairState.NORMAL);
        armchair.breakDown();
        VogonJeltz jeltz = new VogonJeltz(JeltzState.INAGOODMOOD);
        jeltz.anger(armchair);
        Assert.assertEquals(JeltzState.ANGRY, jeltz.getJeltzState());
    }

}
