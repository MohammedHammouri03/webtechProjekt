package de.htwberlin.webtech.web.persistence;

import javax.persistence.*;

@Entity(name = "vokabel")
public class WebsiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word", nullable = true)
    private String word;

    @Column(name = "translation", nullable = true)
    private String translation;

@Column(name = "favorite", nullable = true)
    private boolean favorite;

    public WebsiteEntity(String word, String translation, boolean favorite) {
        this.word = word;
        this.translation = translation;
        this.favorite = favorite;
    }


    protected WebsiteEntity() {
    }

    public Long getId() {
        return id;
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
    public boolean isFavorite() {
        return favorite;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
