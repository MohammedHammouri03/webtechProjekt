package de.htwberlin.webtech.web.api;

public class IdeaManipulationRequest {

    private Long id;

    private String name;

    private String email;

    private String idea;

    public IdeaManipulationRequest(Long id, String name, String email, String idea) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.idea = idea;
    }
public IdeaManipulationRequest(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
