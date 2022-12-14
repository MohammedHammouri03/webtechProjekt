package de.htwberlin.webtech.web.api;

public class PersonManipulationRequest {

    private String firstName;
    private String lastName;

    private String email;
    private String passwort;


    public PersonManipulationRequest(String firstName, String lastName, String email, String passwort) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwort = passwort;
    }
    public PersonManipulationRequest(){}

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

    public String getPasswort(){return passwort;}

    public void setPasswort(String passwort){
        this.passwort = passwort;
    }
}
