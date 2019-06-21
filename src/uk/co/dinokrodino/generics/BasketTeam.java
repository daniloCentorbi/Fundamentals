package uk.co.dinokrodino.generics;

public class BasketTeam extends Team {
    private String sport;

    public BasketTeam(String name, int point) {
        super(name, point);
        this.sport = "basket";
    }
}
