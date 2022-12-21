package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.persistence.ScoreRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ScoreServiceTest implements WithAssertions {

    @Mock
    private ScoreRepository repository;

    @InjectMocks
    private ScoreService underTest;

    @Test
    @DisplayName("should return true if delete is successful")
    void deleteScore() {
        Long givenid = 1L;
        doReturn(true).when(repository).existsById(givenid);
        boolean result = underTest.deleteById(givenid);
        Mockito.verify(repository).deleteById(givenid);
        assertThat(result).isTrue();
    }
}

