package Domain;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Entity {
    EntityState entityState;

    public Entity(EntityState entityState) {
        this.entityState = entityState;
    }

    public EntityState say() {
        return entityState;
    }

    public void makeMistake() {
        entityState = EntityState.MISCONCEPTION;
    }

    public EntityState getEntityState() {
        return entityState;
    }
}
