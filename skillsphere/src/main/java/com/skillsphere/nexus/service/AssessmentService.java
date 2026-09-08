package com.skillsphere.nexus.service;

import com.skillsphere.nexus.entity.Assessment;
import com.skillsphere.nexus.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    public Assessment getAssessmentById(UUID id) {
        return assessmentRepository.findById(id).orElse(null);
    }

    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }
}