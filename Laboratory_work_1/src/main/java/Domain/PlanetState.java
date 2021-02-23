package Domain;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public enum PlanetState {
    DESTROYED("уничтоженный"),
    NOTDESTOYED("не уничтоженный");
    private String message;

    PlanetState(String message) {
        this.message = message;
    }
}
