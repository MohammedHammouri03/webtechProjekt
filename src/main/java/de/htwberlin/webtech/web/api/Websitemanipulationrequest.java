package de.htwberlin.webtech.web.api;

public class Websitemanipulationrequest {

        private String word;

        private String translation;
        private long id;
        private boolean favorite;

        public Websitemanipulationrequest(String word, String translation, long id, boolean favorite) {
            this.word = word;
            this.translation = translation;
            this.id = id;
            this.favorite = favorite;

        }
        public Websitemanipulationrequest(){}

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
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public boolean isFavorite() {
            return favorite;
        }
        public void setFavorite(boolean favorite) {
            this.favorite = favorite;
        }
}
