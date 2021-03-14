import Domain.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class DomainTest {

    // Try to destroy the planet
    @Test
    public void destroyPlanet() {
        Planet planet = new Planet(PlanetState.NOTDESTOYED, PlanetPopulation.UNINHABITED);
        planet.destroy();
        Assert.assertEquals(PlanetState.DESTROYED, planet.getPlanetState());
    }

    // Try to make the planet uninhabited
    @Test
    public void makePlanetUninhabited() {
        Planet planet = new Planet(PlanetState.NOTDESTOYED, PlanetPopulation.UNINHABITED);
        Assert.assertEquals(PlanetPopulation.UNINHABITED, planet.getPlanetPopulation());
    }

    //Check after the destruction, the planet became uninhabitable
    @Test
    public void becameUninhabitable() {
        Planet planet = new Planet(PlanetState.NOTDESTOYED, PlanetPopulation.UNINHABITED);
        planet.destroy();
        Assert.assertEquals(PlanetState.DESTROYED, planet.getPlanetState());
    }

    // Checking that after the destruction of inhabited planets Jeltz will be annoyed
    @Test
    public void willAnnoyed() {
        Planet planet = new Planet(PlanetState.NOTDESTOYED, PlanetPopulation.UNINHABITED);
        planet.destroy();
        planet.populate();
        VogonJeltz jeltz = new VogonJeltz(JeltzState.NORMAL);
        jeltz.toBeAnnoyed(planet);
        Assert.assertEquals(JeltzState.ANNOYED, jeltz.getJeltzState());
    }

    //Entity make misconceptions
    @Test
    public void makeError() {
        Entity entity = new Entity(EntityState.NORMAL);
        entity.makeMistake();
        Assert.assertEquals(EntityState.MISCONCEPTION, entity.getEntityState());
    }

    // Check that after someone told him that they were wrong he would yell and he would feel better
    @Test
    public void yellToSmb() {
        Entity entity = new Entity(EntityState.NORMAL);
        entity.makeMistake();
        VogonJeltz jeltz = new VogonJeltz(JeltzState.ANNOYED);
        jeltz.shout(entity);
        Assert.assertEquals(JeltzState.INAGOODMOOD, jeltz.getJeltzState());
    }

    // Try to broke armchair
    @Test
    public void brokeArmchair() {
        Armchair armchair = new Armchair(ArmchairState.NORMAL);
        armchair.breakDown();
        Assert.assertEquals(ArmchairState.BROKEN, armchair.getArmchairState());
    }

    // Check that the chair can be squeaky
    @Test
    public void checkSqueaky() {
        Armchair armchair = new Armchair(ArmchairState.NORMAL);
        armchair.creak();
        Assert.assertEquals(ArmchairState.SQUEAKY, armchair.getArmchairState());
    }

    // Check that after he plopped down in the chair with all his strength, in the hope that it
    // would break, and he would be able to get genuinely angry
    @Test
    public void toBeAngry() {
        Armchair armchair = new Armchair(ArmchairState.NORMAL);
        armchair.breakDown();
        VogonJeltz jeltz = new VogonJeltz(JeltzState.INAGOODMOOD);
        jeltz.become_angry(armchair);
        Assert.assertEquals(JeltzState.ANGRY, jeltz.getJeltzState());
    }

    // Check if the chair don't break down Jeltz can't be angry
    @Test
    public void notToBeAngry() {
        Armchair armchair = new Armchair(ArmchairState.NORMAL);
        armchair.creak();
        VogonJeltz jeltz = new VogonJeltz(JeltzState.NORMAL);
        jeltz.become_angry(armchair);
        Assert.assertNotEquals(JeltzState.ANGRY, jeltz.getJeltzState());
    }
}