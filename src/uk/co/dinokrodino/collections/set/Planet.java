package uk.co.dinokrodino.collections.set;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon instanceof Moon) {
            return super.addSatellite(moon);
        } else {
            return false;
        }
    }
}
