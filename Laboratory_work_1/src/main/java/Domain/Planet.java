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
        if(this.planetState != PlanetState.DESTROYED) {
            this.planetPopulation = planetPopulation;
        } else {
            this.planetPopulation = PlanetPopulation.UNINHABITED;
        }
    }

    public void destroy() {
        planetState = PlanetState.DESTROYED;
        planetPopulation = PlanetPopulation.UNINHABITED;
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
