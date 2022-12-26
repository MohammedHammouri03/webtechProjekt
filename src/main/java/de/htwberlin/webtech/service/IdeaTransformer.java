package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Idea;
import de.htwberlin.webtech.web.persistence.IdeaEntity;
import org.springframework.stereotype.Service;

@Service
public class IdeaTransformer {

    public Idea transformEntity(IdeaEntity ideaEntity) {
        return new Idea(ideaEntity.getId(), ideaEntity.getName(), ideaEntity.getEmail(), ideaEntity.getIdea());
    }


}
