package uk.co.dinokrodino.collections.mapImmutableClass;

import java.util.HashMap;
import java.util.Map;

//IMMUTABLE CLASS

//should be private(rule 3)
public class Location {
    //rule 2 that help 3 in this class
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String,Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        //rule 4 create a copy from passed list
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q", 0);
        this.exits.put("Q", 0);
    }

//immutable class
    public void addExits(String direction, int locationID){
        exits.put(direction,locationID);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    //rule 4
    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }


}
