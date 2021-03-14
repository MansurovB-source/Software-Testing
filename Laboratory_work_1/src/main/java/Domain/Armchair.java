package Domain;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Armchair {
    private ArmchairState armchairState;

    public Armchair(ArmchairState armchairState) {
        this.armchairState = armchairState;
    }

    public void creak() {
        armchairState = ArmchairState.SQUEAKY;
    }

    public void breakDown() {
        armchairState = ArmchairState.BROKEN;
    }

    public ArmchairState getArmchairState() {
        return armchairState;
    }
}
