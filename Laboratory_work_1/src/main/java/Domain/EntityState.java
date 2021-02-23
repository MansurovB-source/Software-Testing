package Domain;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public enum  EntityState {
    MISCONCEPTION("ошибившийся"),
    NORMAL("Обычное состояние");

    private String message;

    EntityState(String message) {
        this.message = message;
    }
}
