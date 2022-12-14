package de.htwberlin.webtech.web.persistence;

import javax.persistence.*;

@Entity(name = "vocabularies")
public class VocabulariesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word", nullable = true)
    private String word;

    @Column(name = "translation", nullable = true)
    private String translation;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonEntity person;

    public VocabulariesEntity() {
    }

    public VocabulariesEntity(String word, PersonEntity person, String translation) {
        this.word = word;
        this.person = person;
        this.translation = translation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
