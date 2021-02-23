package Domain;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public enum JeltzState {
    NORMAL("нормальное состояние"),
    ANNOYED("раздраженный"),
    ANGRY("разозленный"),
    INAGOODMOOD("в хорошем расположении духа");

    String message;

    JeltzState(String message) {
        this.message = message;
    }
}
