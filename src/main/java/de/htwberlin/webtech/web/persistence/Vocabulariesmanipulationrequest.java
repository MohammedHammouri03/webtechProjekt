package de.htwberlin.webtech.web.persistence;

public class Vocabulariesmanipulationrequest {

    public long id;
    public String word;

    private Long person;

    public Vocabulariesmanipulationrequest(long id, String word, Long person) {
        this.id = id;
        this.word = word;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }
}
