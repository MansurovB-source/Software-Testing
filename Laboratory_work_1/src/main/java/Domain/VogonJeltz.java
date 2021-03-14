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

//  кричать
    public void shout(Entity entity) {
        if(entity.say() == EntityState.MISCONCEPTION) {
            jeltzState = JeltzState.INAGOODMOOD;
        }
    }

//  разозлиться
    public void become_angry(Armchair armchair) {
        if(armchair.getArmchairState() == ArmchairState.BROKEN) {
            jeltzState = JeltzState.ANGRY;
        }
    }
//  быть раздражительным
    public void toBeAnnoyed(Planet planet) {
        if(planet.getPlanetPopulation() == PlanetPopulation.INHABITED && planet.getPlanetState() == PlanetState.DESTROYED) {
            jeltzState = JeltzState.ANNOYED;
        }
    }

    public JeltzState getJeltzState() {
        return jeltzState;
    }
}
