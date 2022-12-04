package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Score;
import de.htwberlin.webtech.web.persistence.ScoreEntity;
import org.springframework.stereotype.Service;

@Service
public class ScoreTransformer {

    public Score transformentity(ScoreEntity scoreEntity) {
        return new Score(scoreEntity.getId(), scoreEntity.getPoints());
    }
}
