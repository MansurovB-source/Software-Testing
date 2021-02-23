package Domain;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class VogonJeltz {
    JeltzState jeltzState;

    public VogonJeltz(JeltzState jeltzState) {
        this.jeltzState = jeltzState;
    }

    public void shout(Entity entity) {
        if(entity.say() == EntityState.MISCONCEPTION) {
            jeltzState = JeltzState.INAGOODMOOD;
        }
    }

    public void anger(Armchair armchair) {
        if(armchair.getArmchairState() == ArmchairState.BROKEN) {
            jeltzState = JeltzState.ANGRY;
        }
    }

    public void toBeAnnoyed(Planet planet) {
        if(planet.getPlanetPopulation() == PlanetPopulation.INHABITED && planet.getPlanetState() == PlanetState.DESTROYED) {
            jeltzState = JeltzState.ANNOYED;
        }
    }

    public JeltzState getJeltzState() {
        return jeltzState;
    }
}
