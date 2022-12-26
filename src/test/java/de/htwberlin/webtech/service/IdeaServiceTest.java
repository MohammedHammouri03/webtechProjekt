package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.persistence.IdeaRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class IdeaServiceTest implements WithAssertions {

    @Mock
    private IdeaRepository repository;

    @InjectMocks
    private IdeaService underTest;

    @Test
    @DisplayName("should return true if delete is successful")
    void deleteIdea() {
        Long givenid = 1L;
        doReturn(true).when(repository).existsById(givenid);
        boolean result = underTest.deleteById(givenid);
        Mockito.verify(repository).deleteById(givenid);
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("should return false if not found for delete ")
    void deleteIdeaNotFound() {
        Long givenid = 1L;
        doReturn(false).when(repository).existsById(givenid);
        boolean result = underTest.deleteById(givenid);
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
}

