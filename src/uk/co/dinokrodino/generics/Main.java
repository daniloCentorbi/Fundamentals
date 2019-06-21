package uk.co.dinokrodino.generics;

public class Main {
    public static void main(String[] args) {
        SoccerTeam milan = new SoccerTeam("Milan", 0);
        SoccerTeam bari = new SoccerTeam("Bari", 10);
        League<SoccerTeam> soccerTeamLeague = new League("serie A");
        soccerTeamLeague.addTeam(milan);
        soccerTeamLeague.addTeam(bari);
        soccerTeamLeague.printList();
        BasketTeam charlotte = new BasketTeam("Charlotte", 0);
        BasketTeam toronto = new BasketTeam("Toronto", 0);
        League<BasketTeam> basketTeamLeague = new League<>("NBA");
        basketTeamLeague.addTeam(charlotte);
        basketTeamLeague.addTeam(toronto);
        basketTeamLeague.printList();

        System.out.println("compareTo" + bari.compareTo(milan));
    }
}
