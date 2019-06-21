package uk.co.dinokrodino.collections.set;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;

    public enum BodyTypes {
        PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();

    }

    public static Key makeKey(String name, BodyTypes bodyTypes){
        return new Key(name, bodyTypes);
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) o;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return  this.key.name + " " + this.key.bodyType + " " + orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellities() {
        return this.satellites;
    }

    public Key getKey() {
        return key;
    }

    public static final class Key{
        private final String name;
        private final BodyTypes bodyType;

        //check why
        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (this.name.equals(((Key)o).name)){
                return (this.bodyType == ((Key)o).bodyType);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 57;
        }
    }
}
