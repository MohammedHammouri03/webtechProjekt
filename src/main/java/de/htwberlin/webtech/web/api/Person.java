package de.htwberlin.webtech.web.api;

import java.util.List;

public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Long> vocabulariesid;

    public Person(long id, String firstName, String lastName, String email, List<Long> vocabulariesid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.vocabulariesid = vocabulariesid;
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
    public void setVocabulariesid(List<Long> vocabulariesid) {
        this.vocabulariesid = vocabulariesid;
    }
    public List<Long> getVocabulariesid() {
        return vocabulariesid;
    }
}
