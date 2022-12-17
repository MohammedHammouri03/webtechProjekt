package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Website;
import de.htwberlin.webtech.web.persistence.WebsiteEntity;
import org.springframework.stereotype.Service;

@Service
public class WebsiteTransformer {

    public Website transformEntityWebsite(WebsiteEntity websiteEntity) {
        return new Website(websiteEntity.getId(), websiteEntity.getWord(),websiteEntity.getTranslation(), websiteEntity.isFavorite());

    }
}
