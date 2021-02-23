package Domain;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Planet {
    private PlanetState planetState;
    private PlanetPopulation planetPopulation;

    public Planet(PlanetState planetState, PlanetPopulation planetPopulation) {
        this.planetState = planetState;
        this.planetPopulation = planetPopulation;
    }

    public void destroy() {
        planetState = PlanetState.DESTROYED;
    }

    public void populate() {
        planetPopulation = PlanetPopulation.INHABITED;
    }

    public PlanetState getPlanetState() {
        return planetState;
    }

    public PlanetPopulation getPlanetPopulation() {
        return planetPopulation;
    }
}
