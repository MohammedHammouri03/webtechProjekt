package de.htwberlin.webtech.web.api;

public class Websitemanipulationrequest {

        private String word;

        private String translation;

        public Websitemanipulationrequest(String word, String translation) {
            this.word = word;
            this.translation = translation;

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
}
