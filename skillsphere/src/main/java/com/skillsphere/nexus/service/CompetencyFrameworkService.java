package com.skillsphere.nexus.service;

import com.skillsphere.nexus.entity.CompetencyFramework;
import com.skillsphere.nexus.repository.CompetencyFrameworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompetencyFrameworkService {

    @Autowired
    private CompetencyFrameworkRepository competencyFrameworkRepository;

    public List<CompetencyFramework> getAllFrameworks() {
        return competencyFrameworkRepository.findAll();
    }

    public CompetencyFramework getFrameworkById(UUID id) {
        return competencyFrameworkRepository.findById(id).orElse(null);
    }

    public CompetencyFramework createFramework(CompetencyFramework framework) {
        return competencyFrameworkRepository.save(framework);
    }
}