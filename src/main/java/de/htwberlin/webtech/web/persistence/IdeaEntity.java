package de.htwberlin.webtech.web.persistence;

import javax.persistence.*;

@Entity(name = "idea")
public class IdeaEntity {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "idea")
    private String idea;

    public void setId(Long id) {
        this.id = id;
    }

    public IdeaEntity(String name, String email, String idea) {
        this.name = name;
        this.email = email;
        this.idea = idea;
    }
    protected IdeaEntity(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }
}
