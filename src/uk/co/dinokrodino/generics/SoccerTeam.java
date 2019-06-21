package uk.co.dinokrodino.generics;

public class SoccerTeam extends Team {
    private String sport;

    public SoccerTeam(String name, int point) {
        super(name, point);
        this.sport = "soccer";
    }

}
