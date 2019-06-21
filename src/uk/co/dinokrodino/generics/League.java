package uk.co.dinokrodino.generics;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;
    ArrayList<T> teams;

    public League(String name) {
        this.name = name;
        teams = new ArrayList<>();
    }

    public boolean addTeam(T team){
        if(teams.contains(team)){
            return false;
        }
        if(team != null){
            teams.add(team);
            return true;
        }
        return false;
    }

    public void printList(){
        Collections.sort(teams);
        for (T t : teams){
            System.out.println("---" + t.getName());
        }
    }
}
