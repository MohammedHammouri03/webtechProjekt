package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Score;
import de.htwberlin.webtech.web.api.Scoremanipulationrequest;
import de.htwberlin.webtech.web.persistence.ScoreEntity;
import de.htwberlin.webtech.web.persistence.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    private final ScoreTransformer scoreTransformer;


    public ScoreService(ScoreRepository scoreRepository, ScoreTransformer scoreTransformer) {
        this.scoreRepository = scoreRepository;
        this.scoreTransformer = scoreTransformer;
    }
    public List<Score> findAll() {
        List<ScoreEntity> score = scoreRepository.findAll();
        return score.stream().map(scoreTransformer::transformentity).collect(Collectors.toList());
    }
    public Score create(Scoremanipulationrequest scoremanipulationrequest) {
        var scoreEntity = new ScoreEntity(scoremanipulationrequest.getPoints());
        scoreEntity = scoreRepository.save(scoreEntity);
        return scoreTransformer.transformentity(scoreEntity);
    }
    public boolean deleteById(Long id) {
        if (!scoreRepository.existsById(id)) {
            return false;
        }
        scoreRepository.deleteById(id);
        return true;
    }
}
