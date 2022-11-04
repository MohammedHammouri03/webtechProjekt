package de.htwberlin.webtech.web.api;

import java.util.List;

public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Long> vocabularies;

    public Person(long id, String firstName, String lastName, String email, List<Long> vocabularies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.vocabularies = vocabularies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setVocabularies(List<Long> vocabulariesid) {
        this.vocabularies = vocabulariesid;
    }
    public List<Long> getVocabularies() {
        return vocabularies;
    }
}
