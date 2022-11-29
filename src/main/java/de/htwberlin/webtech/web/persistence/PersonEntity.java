package de.htwberlin.webtech.web.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = true)
    private String firstname;

    @Column(name = "last_name", nullable = true)
    private String lastname;

    @Column(name = "Email", nullable = true)
    private String email;

    @Column(name = "Passwort", nullable = true)
    private String passwort;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<VocabulariesEntity> vocabulariesid = new ArrayList<>();

    public PersonEntity(String firstname, String lastname, String email, String passwort) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.passwort = passwort;
    }

    protected PersonEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public List<VocabulariesEntity> getVocabularies() {
        return vocabulariesid;
    }

    public void setVocabularies(List<VocabulariesEntity> vocabulariesid) {
        this.vocabulariesid = vocabulariesid;
    }

}
