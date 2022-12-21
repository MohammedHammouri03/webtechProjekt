package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.persistence.WebsiteEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WebsiteTransformerTest implements WithAssertions {

    @Test
    @DisplayName("Should transfrom entity to website/vocabulary")
    void transformEntityWebsite() {

        var websiteTransformer = new WebsiteTransformer();

        var websiteEntity = new WebsiteEntity( "Word", "Wort",  true);

        var website = websiteTransformer.transformEntityWebsite(websiteEntity);

        assertThat(website.getWord()).isEqualTo("Word");
        assertThat(website.getTranslation()).isEqualTo("Wort");
        assertThat(website.isFavorite()).isEqualTo(true);
    }


}
