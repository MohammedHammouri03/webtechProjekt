package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Idea;
import de.htwberlin.webtech.web.api.IdeaManipulationRequest;
import de.htwberlin.webtech.web.persistence.IdeaEntity;
import de.htwberlin.webtech.web.persistence.IdeaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IdeaService {

    private final IdeaRepository ideaRepository;

    private final IdeaTransformer ideaTransformer;

    public IdeaService(IdeaRepository ideaRepository, IdeaTransformer ideaTransformer) {
        this.ideaRepository = ideaRepository;
        this.ideaTransformer = ideaTransformer;
    }

    public List<Idea> findAll() {
        List<IdeaEntity> idea = ideaRepository.findAll();
        return idea.stream().map(ideaTransformer::transformEntity).collect(Collectors.toList());
    }
    public Idea create(IdeaManipulationRequest ideaManipulationRequest) {
        var ideaEntity = new IdeaEntity(ideaManipulationRequest.getName(),ideaManipulationRequest.getEmail(),ideaManipulationRequest.getIdea());
        ideaEntity = ideaRepository.save(ideaEntity);
        return ideaTransformer.transformEntity(ideaEntity);
    }
    public boolean deleteById(Long id) {
        if (!ideaRepository.existsById(id)) {
            return false;
        }
        ideaRepository.deleteById(id);
        return true;
    }
}

