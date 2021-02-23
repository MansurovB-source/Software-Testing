package Domain;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public enum ArmchairState {
    NORMAL("не сломанный"),
    BROKEN("сломанный"),
    SQUEAKY("скрипучий");

    private String message;

    ArmchairState(String message) {
        this.message = message;
    }
}
