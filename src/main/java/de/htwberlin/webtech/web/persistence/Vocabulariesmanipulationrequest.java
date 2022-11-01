package de.htwberlin.webtech.web.persistence;

public class Vocabulariesmanipulationrequest {

    public long id;
    public String word;

    private Long personid;

    public Vocabulariesmanipulationrequest(long id, String word, Long personid) {
        this.id = id;
        this.word = word;
        this.personid = personid;
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

    public Long getPersonid() {
        return personid;
    }

    public void setPersonid(Long personid) {
        this.personid = personid;
    }
}
