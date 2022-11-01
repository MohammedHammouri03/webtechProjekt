package de.htwberlin.webtech.web.persistence;

import javax.persistence.*;

@Entity(name = "vocabularies")
public class VocabulariesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word", nullable = false)
    private String word;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonEntity person;

    public VocabulariesEntity(){}

    public VocabulariesEntity(String word, PersonEntity person) {
        this.word = word;
        this.person = person;
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
}
