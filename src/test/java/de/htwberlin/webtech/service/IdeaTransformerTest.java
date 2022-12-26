package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.persistence.IdeaEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IdeaTransformerTest implements WithAssertions {

    @Test
    @DisplayName("Should transform entity to idea")
    void transformEntityIdea() {

        var ideatransformer = new IdeaTransformer();

        var ideaentity = new IdeaEntity( "momo", "test@gmail.com", "die idee");

        var score = ideatransformer.transformEntity(ideaentity);

        assertThat(ideaentity.getName()).isEqualTo("momo");
        assertThat(ideaentity.getEmail()).isEqualTo("test@gmail.com");
        assertThat(ideaentity.getIdea()).isEqualTo("die idee");
    }
}
