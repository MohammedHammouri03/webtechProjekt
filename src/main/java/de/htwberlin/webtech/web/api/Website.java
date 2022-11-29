package de.htwberlin.webtech.web.api;

public class Website {

    private String word;
private Long id;
    private String translation;

    public Website(String word, String translation) {
        this.word = word;
        this.translation = translation;
        this.id = id;


    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Long getId() {
        return id;
    }
}
