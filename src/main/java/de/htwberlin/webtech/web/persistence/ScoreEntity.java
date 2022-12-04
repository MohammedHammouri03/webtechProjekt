package de.htwberlin.webtech.web.persistence;

import javax.persistence.*;

@Entity(name = "Score")
public class ScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "points")
    private int points;


    public ScoreEntity(int points) {
        this.points = points;
    }
    protected ScoreEntity(){}

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

