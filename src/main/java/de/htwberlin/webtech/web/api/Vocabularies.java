package de.htwberlin.webtech.web.api;

public class Vocabularies {

    private Person person;
    private long id;
    private String word;

    public Vocabularies(long id, String word, Person person) {
        this.id = id;
        this.word = word;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public long setId(long id) {
        return this.id = id;
    }

    public String getWord() {
        return word;
    }

    public String setWord(String word) {
        return this.word = word;
    }
    public Person getPerson() {
        return person;
    }
    public Person setPerson(Person person) {
        return this.person = person;
    }
}
