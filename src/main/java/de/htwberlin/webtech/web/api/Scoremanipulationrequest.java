package de.htwberlin.webtech.web.api;

public class Scoremanipulationrequest {

    private int points;

    private long id;
    public Scoremanipulationrequest(long id, int points){
        this.points = points;
        this.id = id;
    }
    public Scoremanipulationrequest(){}

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
