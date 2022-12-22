package de.htwberlin.webtech.web.persistence;

import de.htwberlin.webtech.service.ScoreService;
import de.htwberlin.webtech.web.api.Score;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScoreRestControllerTest {

    @Mock
    private ScoreService scoreService;

    @InjectMocks
    private ScoreRestController controller;

    @Test
    void testFetchScore() {
        List<Score> expectedScores = List.of(
                new Score(1L, 10),
                new Score(2L, 5)
        );

        when(scoreService.findAll()).thenReturn(expectedScores);

        ResponseEntity<List<Score>> response = controller.fetchScore();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedScores, response.getBody());

        assertAll("scores",
                () -> assertEquals(1L, response.getBody().get(0).getId()),
                () -> assertEquals(10, response.getBody().get(0).getPoints()),
                () -> assertEquals(2L, response.getBody().get(1).getId()),
                () -> assertEquals(5, response.getBody().get(1).getPoints())
        );
    }
}
