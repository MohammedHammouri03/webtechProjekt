package de.htwberlin.webtech.web.api;

public class Vocabularies {

    private Person person;
    private long id;
    private String word;

    private String translation;

    public Vocabularies(long id, String word, Person person, String translation) {
        this.id = id;
        this.word = word;
        this.person = person;
        this.translation = translation;
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
    public String getTranslation() {
        return translation;
    }
    public String setTranslation(String translation) {
        return this.translation = translation;
    }
}
