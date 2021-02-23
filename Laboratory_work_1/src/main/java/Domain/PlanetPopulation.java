package Domain;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public enum  PlanetPopulation {
    INHABITED("обитаемый"),
    UNINHABITED("необитаемый");
    private String message;

    PlanetPopulation(String message) {
        this.message = message;
    }
}
