package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.persistence.ScoreEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTransformerTest implements WithAssertions {

    @Test
    @DisplayName("Should transform entity to score")
    void transformEntityScore() {

        var scoreTransformer = new ScoreTransformer();

        var scoreEntity = new ScoreEntity( 10);

        var score = scoreTransformer.transformentity(scoreEntity);

        assertThat(score.getPoints()).isEqualTo(10);
    }
}
