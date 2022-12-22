package de.htwberlin.webtech.web.api;

public class Website {

    private String word;
    private Long id;
    private String translation;

    private boolean favorite;

    public Website(Long id, String word, String translation, boolean favorite) {
        this.word = word;
        this.translation = translation;
        this.id = id;
        this.favorite = favorite;


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
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isFavorite() {
        return favorite;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
