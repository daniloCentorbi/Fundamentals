package uk.co.dinokrodino.collections.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Initializer {
    private Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private Set<Planet> planets = new HashSet<>();
    private Set<HeavenlyBody> moons = new HashSet<>();


    public void init() {
        Planet temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 255);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Hearth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        Moon tempMoon = new Moon("Moon", 27);
        solarSystem.put(temp.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(temp.getKey(), temp);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(temp.getKey(), temp);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 1111);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Pluto", 229899999);
        solarSystem.put(temp.getKey(), tempMoon);
        temp.addSatellite(tempMoon);


        tempMoon = new Moon("Pluto", 2299);
        solarSystem.put(temp.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            System.out.println(planet);
        }


        if (solarSystem.containsKey(HeavenlyBody.makeKey("Jupiter", HeavenlyBody.BodyTypes.PLANET))) {
            System.out.println("Satellities for Jupiter");
            HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Jupiter", HeavenlyBody.BodyTypes.PLANET));
            for (HeavenlyBody satellite : body.getSatellities()) {
                System.out.println(satellite);
            }
        }

        for (Planet planet : planets) {
            moons.addAll(planet.getSatellities());
        }

        System.out.println("All Satellities in this solar system");
        for (HeavenlyBody moon : moons) {
            System.out.println(moon);
        }

        System.out.println("Solar System contains:");
        for(HeavenlyBody body : solarSystem.values()){
            System.out.println(body);
        }
    }
}
