package uk.co.dinokrodino.generics;

public class Team<T> implements Comparable<Team<T>> {
    private String name;
    private int point;

    public Team(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.getPoint() < team.getPoint()){
            return -1;
        }else if (this.getPoint() > team.getPoint()){
            return 1;
        }else{
            return 0;
        }
    }
}
