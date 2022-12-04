package de.htwberlin.webtech.web.api;

public class Score {

    private long id;

    private int points;

    public Score(long id, int points){
        this.id = id;
        this.points = points;
    }

    public long getId() {
        return id;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
}
