package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.persistence.WebsiteRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WebsiteServiceTest implements WithAssertions {

    @Mock
    private WebsiteRepository repository;

    @InjectMocks
    private WebsiteService underTest;

    @Test
    @DisplayName("should return true if delete is successful")
    void deleteWebsite() {
        Long givenid = 1L;
        doReturn(true).when(repository).existsById(givenid);
        boolean result = underTest.deleteById(givenid);
        verify(repository).deleteById(givenid);
        assertThat(result).isTrue();
    }

}
