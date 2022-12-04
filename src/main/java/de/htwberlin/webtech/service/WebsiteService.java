package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Website;
import de.htwberlin.webtech.web.api.Websitemanipulationrequest;
import de.htwberlin.webtech.web.persistence.WebsiteEntity;
import de.htwberlin.webtech.web.persistence.WebsiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebsiteService {

    private final WebsiteRepository websiteRepository;

    private final WebsiteTransformer websiteTransformer;

    public WebsiteService(WebsiteRepository websiteRepository, WebsiteTransformer websiteTransformer) {
        this.websiteRepository = websiteRepository;
        this.websiteTransformer = websiteTransformer;
    }

    public List<Website> findAll() {
        List<WebsiteEntity> websites = websiteRepository.findAll();
        return websites.stream().map(websiteTransformer::transformEntityWebsite).collect(Collectors.toList());
    }

    public Website create(Websitemanipulationrequest website) {
        var websiteEntity = new WebsiteEntity(website.getWord(), website.getTranslation());
        websiteEntity = websiteRepository.save(websiteEntity);
        return websiteTransformer.transformEntityWebsite(websiteEntity);
    }

    public List<Website> findById(Long id) {
        var websiteEntity = websiteRepository.findById(id);
        return (List<Website>) websiteEntity.map(websiteTransformer::transformEntityWebsite).orElse(null);
    }

    public boolean deleteById(Long id) {
        if (!websiteRepository.existsById(id)) {
            return false;
        }
        websiteRepository.deleteById(id);
        return true;
    }
}
