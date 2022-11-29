package de.htwberlin.webtech.web.api;

public class Vocabulariesmanipulationrequest {

    public long id;
    public String word;

    public String translation;
    private Long person;

    public Vocabulariesmanipulationrequest(long id, String word, Long person, String translation) {
        this.id = id;
        this.word = word;
        this.person = person;
        this.translation = translation;
    }
    public Vocabulariesmanipulationrequest() {
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

    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
